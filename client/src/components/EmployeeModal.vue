<script setup lang="ts">
import type { IEmployee } from "../models/Employee";

const props = defineProps<{ employee: IEmployee | null; visible: boolean }>();
const emit = defineEmits(["close"]);
</script>

<template>
  <div
    v-if="props.visible"
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50 animate-fade"
    @click.self="emit('close')"
  >
    <div class="bg-white rounded-xl shadow-xl p-6 w-full max-w-md animate-pop">
      <h3 class="text-2xl font-semibold mb-4">
        {{ props.employee?.firstName }} {{ props.employee?.lastName }}
      </h3>

      <div class="space-y-2 text-gray-700">
        <p><span class="font-semibold">ID:</span> {{ props.employee?.id }}</p>
        <p><span class="font-semibold">Titel:</span> {{ props.employee?.position }}</p>
      </div>

      <button
        @click="emit('close')"
        class="mt-6 w-full bg-red-900 hover:bg-red-950 text-white py-2 rounded-lg transition cursor-pointer"
      >
        Stäng
      </button>
    </div>
  </div>
</template>

<style scoped>
@keyframes fade {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes pop {
  from { transform: scale(0.95); opacity: 0; }
  to { transform: scale(1); opacity: 1; }
}

.animate-fade {
  animation: fade 0.2s ease-out;
}

.animate-pop {
  animation: pop 0.2s ease-out;
}
</style>
