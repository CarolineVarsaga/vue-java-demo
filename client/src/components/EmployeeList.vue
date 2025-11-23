<script setup lang="ts">
import { inject, type Ref, computed } from "vue";
import type { IEmployee } from "../models/Employee";

const employees = inject<Ref<IEmployee[]>>("employees")!;
const selectedPosition = inject<Ref<string>>("selectedPosition")!;
const loading = inject<Ref<boolean>>("loading")!;
const error = inject<Ref<string | null>>("error")!;

const filteredEmployees = computed(() => {
  if (!selectedPosition.value) return employees.value;
  return employees.value.filter(e => e.position === selectedPosition.value);
});
</script>

<template>
  <h2>Anställda från Java Backend</h2>

  <p v-if="loading">Laddar anställda...</p>
  <p v-else-if="error" style="color: red; font-weight: bold;">{{ error }}</p>

  <table v-else-if="filteredEmployees.length > 0">
    <thead>
      <tr>
        <th>ID</th>
        <th>Förnamn</th>
        <th>Efternamn</th>
        <th>Titel</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="emp in filteredEmployees" :key="emp.id">
        <td>{{ emp.id }}</td>
        <td>{{ emp.firstName }}</td>
        <td>{{ emp.lastName }}</td>
        <td>{{ emp.position }}</td>
      </tr>
    </tbody>
  </table>

  <p v-else>Inga anställda hittades i backend.</p>
</template>

<style scoped>
table {
  margin-top: 20px;
  width: 80%;
  border-collapse: collapse;
}
th, td {
  border: 1px solid #ccc;
  padding: 10px;
  text-align: left;
}
th {
  background-color: #364063;
}
</style>
