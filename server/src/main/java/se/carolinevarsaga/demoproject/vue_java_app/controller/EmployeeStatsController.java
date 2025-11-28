package se.carolinevarsaga.demoproject.vue_java_app.controller;

import se.carolinevarsaga.demoproject.vue_java_app.repository.EmployeeStatsDto;
import se.carolinevarsaga.demoproject.vue_java_app.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class EmployeeStatsController {

  private final EmployeeService employeeService;

  public EmployeeStatsController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public EmployeeStatsDto getStats() {
    return employeeService.getStatistics();
  }
}
