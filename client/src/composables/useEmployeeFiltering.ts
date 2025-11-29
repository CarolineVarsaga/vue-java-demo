import { ref, computed, inject, type Ref } from "vue";
import type { IEmployee } from "../models/Employee";

type SortKey = "firstName" | "lastName" | "position";

export const useEmployeeFiltering = () => {
  const employees = inject<Ref<IEmployee[]>>("employees")!;
  const positions = inject<Ref<string[]>>("positions")!;

  const selectedPosition = ref("");
  const searchQuery = ref("");
  const sortKey = ref<SortKey>("firstName");
  const favorites = ref<Set<number>>(new Set());

  const currentPage = ref(1);
  const pageSize = ref(5);
  // ==============================
  const filteredEmployees = computed(() => {
    let list = [...employees.value];

    if (selectedPosition.value)
      list = list.filter((e) => e.position === selectedPosition.value);
    if (searchQuery.value) {
      const q = searchQuery.value.toLowerCase();
      list = list.filter(
        (e) =>
          e.firstName.toLowerCase().includes(q) ||
          e.lastName.toLowerCase().includes(q)
      );
    }

    list = list.sort((a, b) =>
      a[sortKey.value].localeCompare(b[sortKey.value])
    );
    list.sort(
      (a, b) =>
        (favorites.value.has(a.id) ? -1 : 0) -
        (favorites.value.has(b.id) ? -1 : 0)
    );

    return list;
  });
  // ==============================
  const totalPages = computed(() =>
    Math.ceil(filteredEmployees.value.length / pageSize.value)
  );

  const paginatedEmployees = computed(() => {
    const start = (currentPage.value - 1) * pageSize.value;
    const end = start + pageSize.value;
    return filteredEmployees.value.slice(start, end);
  });
  // ==============================
  const toggleFavorite = (emp: IEmployee) => {
    if (favorites.value.has(emp.id)) favorites.value.delete(emp.id);
    else favorites.value.add(emp.id);
  };

  return {
    positions,
    selectedPosition,
    searchQuery,
    sortKey,
    favorites,
    paginatedEmployees,
    totalPages,
    currentPage,
    pageSize,
    toggleFavorite,
  };
};
