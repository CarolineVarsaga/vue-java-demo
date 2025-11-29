import { ref } from "vue";
import type { IEmployee } from "../models/Employee";

export const useModalHandler = () => {
  const selectedEmployee = ref<IEmployee | null>(null);
  const showModal = ref(false);

  const openModal = (emp: IEmployee) => {
    selectedEmployee.value = emp;
    showModal.value = true;
  };

  const closeModal = () => {
    showModal.value = false;
    selectedEmployee.value = null;
  };

  return { selectedEmployee, showModal, openModal, closeModal };
};
