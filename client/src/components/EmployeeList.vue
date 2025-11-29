<script setup lang="ts">
import { ref, inject, type Ref } from "vue";
import type { IEmployee } from "../models/Employee";
import FilterBar from "./FilterBar.vue";
import EmployeeTable from "./EmployeeTable.vue";
import EmployeeModal from "./EmployeeModal.vue";
import { useEmployeeFiltering } from "../composables/useEmployeeFiltering.ts"; 

const loading = inject<Ref<boolean>>("loading")!;
const error = inject<Ref<string | null>>("error")!;
const {
    positions,
    selectedPosition,
    searchQuery,
    sortKey,
    favorites,
    paginatedEmployees,
    totalPages,
    currentPage,
    toggleFavorite
} = useEmployeeFiltering();
const selectedEmployee = ref<IEmployee | null>(null);
const showModal = ref(false);

const openModal = (emp: IEmployee) => {
    selectedEmployee.value = emp;
    showModal.value = true;
}

const closeModal = () => {
    showModal.value = false;
    selectedEmployee.value = null;
}
</script>

<template>
  <div class="max-w-6xl mx-auto p-6 space-y-6">
    <h2 class="text-2xl font-bold text-gray-50">Anställda hämtade från Java Backend</h2>
    <p v-if="loading" class="text-gray-600">Laddar anställda...</p>

    <p v-else-if="error" class="text-red-600 font-semibold">
      {{ error }}
    </p>

    <div v-else class="space-y-6">

      <div class="bg-white p-4 rounded-xl shadow-md">
        <FilterBar
          :positions="positions"
          v-model:selectedPosition="selectedPosition"
          v-model:searchQuery="searchQuery"
          v-model:sortKey="sortKey"
        />
      </div>

      <div class="bg-white rounded-xl shadow-md overflow-hidden">
        <EmployeeTable
          :employees="paginatedEmployees"
          :favorites="favorites"
          @toggleFavorite="toggleFavorite"
          @openModal="openModal"
        />
      </div>

      <EmployeeModal
        :employee="selectedEmployee"
        :visible="showModal"
        @click="closeModal"
      />

      <div class="flex items-center gap-4 justify-center pt-4">
        <button
          :disabled="currentPage === 1"
          @click="currentPage--"
          class="px-4 py-2 rounded-lg bg-gray-100 disabled:bg-gray-400 disabled:text-gray-700 disabled:cursor-auto hover:bg-gray-200 transition cursor-pointer"
        >
          Föregående
        </button>

        <span class="text-gray-50 font-medium">
          Sida {{ currentPage }} av {{ totalPages }}
        </span>

        <button
          :disabled="currentPage === totalPages"
          @click="currentPage++"
          class="px-4 py-2 rounded-lg bg-gray-100 disabled:bg-gray-400 disabled:text-gray-700 disabled:cursor-auto hover:bg-gray-200 transition cursor-pointer"
        >
          Nästa
        </button>
      </div>

    </div>
  </div>
</template>
