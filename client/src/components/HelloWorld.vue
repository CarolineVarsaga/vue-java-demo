<script setup lang="ts">
import { ref, onMounted } from 'vue'
import axios, { isAxiosError } from 'axios'

const javaMessage = ref('Laddar meddelande från backend via Axios...')

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/hello');

    javaMessage.value = response.data; 
  } catch (error) {
    console.error('Kunde inte nå Spring Boot API:', error);

    if (isAxiosError(error)) {        
      if (error.response) {
        javaMessage.value = 'FEL: Servern svarade med statuskod ' + error.response.status;
      } else if (error.request) {
        javaMessage.value = 'FEL: Ingen respons mottagen (Är Java-servern igång på port 8080?)';
      } else {
        javaMessage.value = 'FEL: Internt Axios-fel: ' + error.message;
      }
    } else {
      javaMessage.value = 'Oväntat fel uppstod: ' + (error as Error).message;
    }
  }
})
</script>

<template>
  <h1>Vue Frontend</h1>
  
  <p>Backend Status:</p>
  <p style="font-weight: bold; color: green;">{{ javaMessage }}</p>
</template>

<style scoped>

</style>
