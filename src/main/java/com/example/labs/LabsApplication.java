package com.example.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
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
