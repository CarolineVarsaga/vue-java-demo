package se.carolinevarsaga.demoproject.vue_java_app.DTO;

import java.util.List;
import java.util.Map;

public record EmployeeStatsDto(
    long totalEmployees,
    Map<String, Long> employeesPerPosition,
    long addedLast30Days,
    List<String> top5Positions) {
}
