package springBoot3.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.GetExchange;
import springBoot3.entities.Customer;

import java.util.List;

@Service
public class customerService {
    private final RestTemplate restTemplate;

    public customerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Customer> listCustomer() {
        ResponseEntity<List<Customer>> exchange = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return exchange.getBody();
    }
}
