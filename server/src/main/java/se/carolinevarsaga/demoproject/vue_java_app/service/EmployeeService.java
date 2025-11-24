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
    employees.add(new Employee(4L, "Kurt", "Berg", "Projektledare"));
    employees.add(new Employee(5L, "Lotta", "Andersson", "UX Designer"));
    employees.add(new Employee(6L, "Jerry", "Klar", "UX Designer"));
    employees.add(new Employee(7L, "Sara", "Holm", "Utvecklare"));
    employees.add(new Employee(8L, "Peter", "Johansson", "Testare"));
    employees.add(new Employee(9L, "Eva", "Sundberg", "Utvecklare"));
    employees.add(new Employee(10L, "Magnus", "Lind", "Projektledare"));
    employees.add(new Employee(11L, "Carina", "Björk", "UX Designer"));
    employees.add(new Employee(12L, "Thomas", "Hansson", "Testare"));
    employees.add(new Employee(13L, "Linda", "Karlsson", "Utvecklare"));
    employees.add(new Employee(14L, "Johan", "Fredriksson", "Projektledare"));
    employees.add(new Employee(15L, "Maria", "Nyström", "UX Designer"));
    employees.add(new Employee(16L, "Anders", "Olsson", "Utvecklare"));
    employees.add(new Employee(17L, "Sofia", "Lund", "Testare"));
    employees.add(new Employee(18L, "Björn", "Åberg", "Projektledare"));
    employees.add(new Employee(19L, "Kristin", "Ek", "UX Designer"));
    employees.add(new Employee(20L, "Henrik", "Pettersson", "Utvecklare"));

    return employees;
  }
}