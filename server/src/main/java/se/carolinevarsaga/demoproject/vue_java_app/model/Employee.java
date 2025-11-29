package se.carolinevarsaga.demoproject.vue_java_app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  private Long id;
  private String firstName;
  private String lastName;
  private String position;
  private LocalDate createdAt;
}