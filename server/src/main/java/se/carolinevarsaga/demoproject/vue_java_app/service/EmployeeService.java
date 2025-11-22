package se.carolinevarsaga.demoproject.vue_java_app.service;

import se.carolinevarsaga.demoproject.vue_java_app.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeService {
  public List<Employee> findAll() {
    // --- Dummy Data ---
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1L, "Anna", "Svensson", "Utvecklare"));
    employees.add(new Employee(2L, "Erik", "Nilsson", "Projektledare"));
    employees.add(new Employee(3L, "Karin", "Larsson", "UX Designer"));

    return employees;
  }
}