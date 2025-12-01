<script setup lang="ts">
import type { IEmployee } from "../models/Employee";

const props = defineProps<{
  employees: IEmployee[];
  favorites: Set<number>;
}>();

const emit = defineEmits<{
  (e: 'toggleFavorite', emp: IEmployee): void;
  (e: 'openModal', emp: IEmployee): void;
}>();
</script>

<template>
  <div>
    <table
      v-if="props.employees.length > 0"
      class="min-w-full table-auto border-collapse"
    >
      <thead class="bg-gray-100 text-gray-700 text-sm uppercase font-semibold">
        <tr>
          <th class="px-6 py-3 text-left">ID</th>
          <th class="px-4 py-3 text-left">Förnamn</th>
          <th class="px-4 py-3 text-left">Efternamn</th>
          <th class="px-4 py-3 text-left">Titel</th>
          <th class="px-4 py-3 text-center">Favorit</th>
        </tr>
      </thead>

      <tbody>
        <tr
          v-for="emp in props.employees"
          :key="emp.id"
          @click="() => emit('openModal', emp)"
          class="border-b hover:bg-gray-50 cursor-pointer transition"
        >
          <td class="px-6 py-3 text-gray-800">{{ emp.id }}</td>
          <td class="px-4 py-3 text-gray-800">{{ emp.firstName }}</td>
          <td class="px-4 py-3 text-gray-800">{{ emp.lastName }}</td>
          <td class="px-4 py-3 text-gray-800">{{ emp.position }}</td>
          
          <td class="px-4 py-3 text-center">
            <button
              @click.stop="() => emit('toggleFavorite', emp)"
              class="text-3xl hover:scale-125 transition-transform cursor-pointer"
              :class="props.favorites.has(emp.id) ? 'text-yellow-400' : 'text-gray-400'"
            >
              {{ props.favorites.has(emp.id) ? '⭐' : '☆' }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <p v-else class="text-gray-500 text-center py-4">
      Inga anställda hittades.
    </p>
  </div>
</template>
