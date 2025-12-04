package se.carolinevarsaga.demoproject.vue_java_app.controller;

import se.carolinevarsaga.demoproject.vue_java_app.dto.EmployeeStatsDto;
import se.carolinevarsaga.demoproject.vue_java_app.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class EmployeeStatsController {

  private final EmployeeService employeeService;

  @GetMapping
  public EmployeeStatsDto getStats() {
    return employeeService.getStatistics();
  }
}
