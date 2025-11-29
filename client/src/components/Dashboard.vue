<script setup lang="ts">
import { ref, onMounted } from "vue";
import PositionBarChart from "./PositionBarChart.vue";
import { getStats } from "../services/employeeService.ts";
import type { IStats } from "../models/Employee.ts";

const stats = ref<IStats | null>(null);
const loading = ref(true);
const error = ref<string | null>(null);

const fetchStats = async () => {
  loading.value = true;
  error.value = null;

  try {
    stats.value = await getStats();
  } catch (err: any) {
    error.value = err.message;
  } finally {
    loading.value = false;
  }
};

onMounted(() => {
  fetchStats();
});
</script>

<template>
  <div class="max-w-6xl mx-auto p-6 space-y-6">
    <h1 class="text-3xl font-bold text-gray-50 mb-6">Statistik Dashboard</h1>

    <p v-if="loading">Laddar statistik...</p>
    <p v-if="error" class="text-red-500 font-bold">{{ error }}</p>

    <div v-if="stats" class="grid grid-cols-1 md:grid-cols-3 gap-6">
      <div class="bg-white shadow-md rounded-lg p-6 text-center">
        <p class="text-gray-500">Totalt anställda</p>
        <p class="text-3xl font-bold">{{ stats.totalEmployees }}</p>
      </div>

      <div class="bg-white shadow-md rounded-lg p-6 text-center">
        <p class="text-gray-500">Nyanställda senaste 30 dagar</p>
        <p class="text-3xl font-bold">{{ stats.addedLast30Days }}</p>
      </div>

      <div class="bg-white shadow-md rounded-lg p-6">
        <p class="text-gray-500 mb-2">Topp 5 roller</p>
        <ul class="list-disc list-inside">
          <li v-for="role in stats.top5Positions" :key="role">{{ role }}</li>
        </ul>
      </div>
    </div>

    <PositionBarChart 
      v-if="stats" 
      :employees-per-position="stats.employeesPerPosition" 
    />
  </div>
</template>
