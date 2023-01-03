package springBoot3.services;

import org.springframework.web.service.annotation.GetExchange;
import springBoot3.entities.Customer;

import java.util.List;

public interface jsonPlaceHolder {
    @GetExchange("/posts")
    List<Customer> loadCustomer();
}
