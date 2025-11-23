import axios from "axios";
import { isAxiosError } from "axios";
import type { IEmployee } from "../models/Employee.ts";

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;
const EMPLOYEE_URL = `${API_BASE_URL}/employees`;

export async function fetchAllEmployees(): Promise<IEmployee[]> {
  try {
    const response = await axios.get<IEmployee[]>(EMPLOYEE_URL);
    return response.data;
  } catch (error) {
    if (isAxiosError(error)) {
      const status = error.response ? error.response.status : "N/A";
      throw new Error(
        `API Error: Kunde inte hämta anställda. Status: ${status}`
      );
    }
    throw new Error("Ett oväntat nätverksfel inträffade.");
  }
}
