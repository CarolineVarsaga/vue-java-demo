<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios, { isAxiosError } from 'axios'

interface IEmployee {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
}

const employees = ref<IEmployee[]>([])
const loading = ref(true)
const error = ref<string | null>(null)
const API_URL = 'http://localhost:8080/api/employees';

onMounted(async () => {
  try {
    const response = await axios.get(API_URL);
    
    employees.value = response.data;
    loading.value = false;
  } catch (err) {
    loading.value = false;
    
    if (isAxiosError(err)) {
      error.value = 'Kunde inte hämta anställda: ' + 
        (err.response 
          ? `Serverfel (${err.response.status})` 
          : 'Kan inte nå Java-servern (Är den igång?)');
    } else {
      error.value = 'Ett oväntat fel uppstod.';
    }
  }
})
</script>

<template>
  <h2>Anställda från Java Backend</h2>
    
  <p v-if="loading">Laddar anställda...</p>
  <p v-else-if="error" style="color: red; font-weight: bold;">{{ error }}</p>
  
  <table v-else-if="employees.length > 0">
    <thead>
      <tr>
        <th>ID</th>
        <th>Förnamn</th>
        <th>Efternamn</th>
        <th>Titel</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="emp in employees" :key="emp.id">
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
