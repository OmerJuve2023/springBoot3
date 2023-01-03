package springBoot3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springBoot3.entities.Customer;
import springBoot3.exception.PostNotFound;
import springBoot3.repositories.CustomerRepository;

import java.util.List;

@RestController
public class springController {

    private final CustomerRepository customerRepository;

    public springController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping({"/", "/index"})
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Welcome to Spring Boot 3");
    }

    @GetMapping("/txt")
    public ResponseEntity<List<Customer>> txt() {
        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/{id}")
    public Customer findbyId(@PathVariable Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new PostNotFound(id));
    }
}
