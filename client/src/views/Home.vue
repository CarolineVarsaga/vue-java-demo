<script setup lang="ts">
import { ref, provide, onMounted } from "vue";
import EmployeeFilter from "../components/EmployeeFilter.vue";
import EmployeeList from "../components/EmployeeList.vue";
import { fetchAllEmployees } from "../services/employeeService";
import type { IEmployee } from "../models/Employee";

const employees = ref<IEmployee[]>([]);
const positions = ref<string[]>([]);

const selectedPosition = ref("");
function setPosition(pos: string) {
  selectedPosition.value = pos;
}

provide("employees", employees);
provide("positions", positions);
provide("selectedPosition", selectedPosition);
provide("setPosition", setPosition);

onMounted(async () => {
  const data = await fetchAllEmployees();
  employees.value = data;

  positions.value = [...new Set(data.map(emp => emp.position))];
});
</script>

<template>
  <h1>Välkommen!</h1>

  <EmployeeFilter />
  <EmployeeList />
</template>
