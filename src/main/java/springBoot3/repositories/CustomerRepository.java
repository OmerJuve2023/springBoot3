package springBoot3.repositories;

import org.springframework.data.repository.ListCrudRepository;
import springBoot3.entities.Customer;

public interface CustomerRepository extends ListCrudRepository<Customer, Integer> {

}
