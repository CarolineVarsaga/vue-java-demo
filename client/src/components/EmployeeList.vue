<script setup lang="ts">
import { ref, computed, inject, type Ref } from "vue";
import type { IEmployee } from "../models/Employee";

import FilterBar from "./FilterBar.vue";
import EmployeeTable from "./EmployeeTable.vue";
import EmployeeModal from "./EmployeeModal.vue";

const employees = inject<Ref<IEmployee[]>>("employees")!;
const positions = inject<Ref<string[]>>("positions")!;
const loading = inject<Ref<boolean>>("loading")!;
const error = inject<Ref<string | null>>("error")!;

const selectedPosition = ref("");
const searchQuery = ref("");
const sortKey = ref<"firstName" | "lastName" | "position">("firstName");
const favorites = ref<Set<number>>(new Set());

const selectedEmployee = ref<IEmployee | null>(null);
const showModal = ref(false);

const currentPage = ref(1);
const pageSize = ref(5);
const totalPages = computed(() => Math.ceil(filteredEmployees.value.length / pageSize.value));

const paginatedEmployees = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  const end = start + pageSize.value;
  return filteredEmployees.value.slice(start, end);
});


const filteredEmployees = computed(() => {
  let list = [...employees.value]; 

  if (selectedPosition.value) list = list.filter(e => e.position === selectedPosition.value);
  if (searchQuery.value) {
    const q = searchQuery.value.toLowerCase();
    list = list.filter(e =>
      e.firstName.toLowerCase().includes(q) || e.lastName.toLowerCase().includes(q)
    );
  }

  list = list.sort((a, b) => a[sortKey.value].localeCompare(b[sortKey.value]));
  list.sort((a, b) => (favorites.value.has(a.id) ? -1 : 0) - (favorites.value.has(b.id) ? -1 : 0));

  return list;
});

function toggleFavorite(emp: IEmployee) {
  if (favorites.value.has(emp.id)) favorites.value.delete(emp.id);
  else favorites.value.add(emp.id);
}

function openModal(emp: IEmployee) {
  selectedEmployee.value = emp;
  showModal.value = true;
}

function closeModal() {
  showModal.value = false;
  selectedEmployee.value = null;
}
</script>

<template>
  <div class="space-y-6">
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

