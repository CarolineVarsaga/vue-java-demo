package se.carolinevarsaga.demoproject.vue_java_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class HelloController {

  @GetMapping("/api/hello")
  public String sayHello() {
    return "Hello from Spring Boot! Back end is running!";
  }
}
