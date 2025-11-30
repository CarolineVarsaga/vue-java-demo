package se.carolinevarsaga.demoproject.vue_java_app.repository;

import se.carolinevarsaga.demoproject.vue_java_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  List<Employee> findByIsDeletedFalse();
}