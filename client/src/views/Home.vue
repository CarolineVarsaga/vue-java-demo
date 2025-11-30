<script setup lang="ts">
import { ref, provide, onMounted } from "vue";
import EmployeeList from "../components/EmployeeList.vue";
import { fetchAllEmployees } from "../services/employeeService";
import type { IEmployee } from "../models/Employee";
import Dashboard from "../components/Dashboard.vue";

const employees = ref<IEmployee[]>([]);
const positions = ref<string[]>([]);
const error = ref<string | null>(null);
provide("error", error);

const selectedPosition = ref("");
const setPosition = (pos: string) => {
  selectedPosition.value = pos;
}

provide("employees", employees);
provide("positions", positions);
provide("selectedPosition", selectedPosition);
provide("setPosition", setPosition);

onMounted(async () => {
  try {
    const data = await fetchAllEmployees();
    employees.value = data;
    positions.value = [...new Set(data.map(emp => emp.position))];
  } catch (err) {
    error.value = "Kunde inte hämta anställda";
  }
});
</script>

<template>
  <div class="max-w-7xl mx-auto p-6 space-y-6">
    <h1 class="text-3xl font-bold text-gray-50">Välkommen!</h1>
    <div v-if="employees.length > 0">
      <Dashboard /> 
      <EmployeeList />     
    </div>
  </div>
</template>
