<script setup lang="ts">
import { ref, watch } from "vue";

const props = defineProps<{
  positions: string[];
  selectedPosition: string;
  searchQuery: string;
  sortKey: string;
}>();

const emit = defineEmits<{
  (e: 'update:selectedPosition', value: string): void;
  (e: 'update:searchQuery', value: string): void;
  (e: 'update:sortKey', value: string): void;
}>();

const localPosition = ref(props.selectedPosition);
const localSearch = ref(props.searchQuery);
const localSort = ref(props.sortKey);

watch(localPosition, val => emit("update:selectedPosition", val));
watch(localSearch, val => emit("update:searchQuery", val));
watch(localSort, val => emit("update:sortKey", val));
</script>

<template>
  <div class="mb-6 flex flex-wrap gap-4 items-center">
    <div class="flex flex-col grow max-w-[200px]">
      <label class="text-sm font-medium text-gray-700 mb-1">Sortering</label>
       <select
        :value="props.sortKey"
        @change="$emit('update:sortKey', ($event.target as HTMLSelectElement).value)"
        class="px-3 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring focus:ring-blue-300 bg-white"
      >
        <option value="firstName">Förnamn</option>
        <option value="lastName">Efternamn</option>
        <option value="position">Titel</option>
      </select>
    </div>

    <div class="flex flex-col grow max-w-[200px]">
      <label class="text-sm font-medium text-gray-700 mb-1">Välj yrke</label>
       <select
        :value="props.selectedPosition"
        @change="$emit('update:selectedPosition', ($event.target as HTMLSelectElement).value)"
        class="px-3 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring focus:ring-blue-300 bg-white"
      >
        <option value="">Alla</option>
        <option v-for="role in props.positions" :key="role" :value="role">
          {{ role }}
        </option>
      </select>
    </div>

    <div class="flex flex-col grow min-w-[200px]">
      <label class="text-sm font-medium text-gray-700 mb-1">Sök</label>
      <input
        type="text"
        :value="props.searchQuery"
        @input="$emit('update:searchQuery', ($event.target as HTMLInputElement).value)"
        placeholder="Sök på namn..."
        class="px-3 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring focus:ring-blue-300 bg-white"
      />
    </div>

  </div>
</template>
