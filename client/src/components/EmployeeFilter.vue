<script setup lang="ts">
import { inject, type Ref } from "vue";

const positions = inject<Ref<string[]>>("positions")!;
const selectedPosition = inject<Ref<string>>("selectedPosition")!;
const setPosition = inject<(val: string) => void>("setPosition")!;
</script>

<template>
  <label>Välj yrke:</label>

  <select v-model="selectedPosition" @change="setPosition(selectedPosition)">
    <option value="">Alla</option>
    <option v-for="role in positions" :key="role" :value="role">
      {{ role }}
    </option>
  </select>
</template>
