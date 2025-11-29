package se.carolinevarsaga.demoproject.vue_java_app.service;

import se.carolinevarsaga.demoproject.vue_java_app.dto.EmployeeDto;
import se.carolinevarsaga.demoproject.vue_java_app.dto.EmployeeStatsDto;
import se.carolinevarsaga.demoproject.vue_java_app.mock.MockEmployees;
import se.carolinevarsaga.demoproject.vue_java_app.model.Employee;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class EmployeeService {
  public List<EmployeeDto> findAll() {
    return MockEmployees.getMockEmployees().stream()
        .map(this::mapToDto)
        .toList();
  }

  private EmployeeDto mapToDto(Employee employee) {
    return new EmployeeDto(
        employee.getId(),
        employee.getFirstName(),
        employee.getLastName(),
        employee.getPosition(),
        employee.getCreatedAt());
  }

  public EmployeeStatsDto getStatistics() {
    List<EmployeeDto> all = findAll();
    long total = all.size();

    Map<String, Long> perPosition = all.stream()
        .collect(Collectors.groupingBy(EmployeeDto::position, Collectors.counting()));

    long last30days = all.stream()
        .filter(e -> e.createdAt().isAfter(LocalDate.now().minusDays(30)))
        .count();

    List<String> top5 = perPosition.entrySet().stream()
        .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
        .limit(5)
        .map(Map.Entry::getKey)
        .toList();

    return new EmployeeStatsDto(total, perPosition, last30days, top5);
  }
}