package se.carolinevarsaga.demoproject.vue_java_app.dto;

import java.time.LocalDate;

public record EmployeeDto(
    Long id,
    String firstName,
    String lastName,
    String position,
    LocalDate hireDate) {
}
