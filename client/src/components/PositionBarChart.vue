<script setup lang="ts">
import { ref, onMounted, onUnmounted, watch } from "vue";
import ChartJS from "chart.js/auto";

const props = defineProps<{
  employeesPerPosition: Record<string, number>;
}>();

const chartRef = ref<HTMLCanvasElement | null>(null);
let chartInstance: ChartJS | null = null;

const renderChart = (data: Record<string, number>) => {
  if (!chartRef.value) return;

  if (chartInstance) chartInstance.destroy();

  chartInstance = new ChartJS(chartRef.value, {
    type: "bar",
    data: {
      labels: Object.keys(data),
      datasets: [
        {
          label: "Antal anställda",
          data: Object.values(data),
          backgroundColor: "#3b82f6",
        },
      ],
    },
    options: {
      responsive: true,
      plugins: {
        legend: { display: false },
      },
    },
  });
};

onMounted(() => {
  renderChart(props.employeesPerPosition);
});

onUnmounted(() => {
  if (chartInstance) chartInstance.destroy();
});

watch(() => props.employeesPerPosition, (newData) => {
    if (newData) renderChart(newData);
});
</script>

<template>
  <div class="bg-white shadow-md rounded-lg p-6">
    <canvas ref="chartRef"></canvas>
  </div>
</template>