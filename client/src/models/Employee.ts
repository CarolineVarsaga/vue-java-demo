export interface IEmployee {
  id: number;
  firstName: string;
  lastName: string;
  position: string;
  createdAt: string;
}
export interface IStats {
  totalEmployees: number;
  employeesPerPosition: Record<string, number>;
  addedLast30Days: number;
  top5Positions: string[];
}
