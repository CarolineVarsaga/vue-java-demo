package se.carolinevarsaga.demoproject.vue_java_app.controller;

import se.carolinevarsaga.demoproject.vue_java_app.dto.EmployeeDto;
import se.carolinevarsaga.demoproject.vue_java_app.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public List<EmployeeDto> getAllEmployees() {
    return employeeService.findAll();
  }
}
