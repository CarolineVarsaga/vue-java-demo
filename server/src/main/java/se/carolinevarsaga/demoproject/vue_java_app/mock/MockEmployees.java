package se.carolinevarsaga.demoproject.vue_java_app.mock;

import se.carolinevarsaga.demoproject.vue_java_app.model.Employee;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class MockEmployees {

  public static List<Employee> getMockEmployees() {
    List<Employee> employees = new ArrayList<>();

    employees.add(new Employee(1L, "Anna", "Svensson", "Utvecklare", LocalDate.now().minusDays(5)));
    employees.add(new Employee(2L, "Erik", "Nilsson", "Projektledare", LocalDate.now().minusDays(40)));
    employees.add(new Employee(3L, "Karin", "Larsson", "UX Designer", LocalDate.now().minusDays(12)));
    employees.add(new Employee(4L, "Kurt", "Berg", "Projektledare", LocalDate.now().minusDays(1)));
    employees.add(new Employee(5L, "Lotta", "Andersson", "UX Designer", LocalDate.now().minusDays(18)));
    employees.add(new Employee(6L, "Jerry", "Klar", "UX Designer", LocalDate.now().minusDays(90)));
    employees.add(new Employee(7L, "Sara", "Holm", "Utvecklare", LocalDate.now().minusDays(3)));
    employees.add(new Employee(8L, "Peter", "Johansson", "Testare", LocalDate.now().minusDays(70)));
    employees.add(new Employee(9L, "Eva", "Sundberg", "Utvecklare", LocalDate.now().minusDays(10)));
    employees.add(new Employee(10L, "Magnus", "Lind", "IT-tekniker", LocalDate.now().minusDays(27)));
    employees.add(new Employee(11L, "Carina", "Björk", "UX Designer", LocalDate.now().minusDays(2)));
    employees.add(new Employee(12L, "Thomas", "Hansson", "Testare", LocalDate.now().minusDays(130)));
    employees.add(new Employee(13L, "Linda", "Karlsson", "Utvecklare", LocalDate.now().minusDays(6)));
    employees.add(new Employee(14L, "Johan", "Fredriksson", "IT-tekniker", LocalDate.now().minusDays(55)));
    employees.add(new Employee(15L, "Maria", "Nyström", "UX Designer", LocalDate.now().minusDays(8)));
    employees.add(new Employee(16L, "Anders", "Olsson", "Utvecklare", LocalDate.now().minusDays(25)));
    employees.add(new Employee(17L, "Sofia", "Lund", "Testare", LocalDate.now().minusDays(16)));
    employees.add(new Employee(18L, "Björn", "Åberg", "Projektledare", LocalDate.now().minusDays(14)));
    employees.add(new Employee(19L, "Kristin", "Ek", "Testare", LocalDate.now().minusDays(4)));
    employees.add(new Employee(20L, "Henrik", "Pettersson", "Utvecklare", LocalDate.now().minusDays(33)));

    return employees;
  }
}