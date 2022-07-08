package com.example.labs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication(scanBasePackages = { "com.example.labs.*" })
@ComponentScan({ "com.example.labs.controller","com.example.labs.repository", "com.example.labs.service" })
@EntityScan("com.example.labs.domain")
@EnableJpaRepositories("com.example.labs.repository")
public class LabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabsApplication.class, args);
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(value="name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/add")
    public String addStudent(
            @RequestParam(value="name") String name,
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password,
            @RequestParam(value="majorId") int majorId) {
        return String.format("Estudiante agregado: %s: %s", name, email);
    }
}
