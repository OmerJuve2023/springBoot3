package springBoot3;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import springBoot3.entities.Customer;
import springBoot3.repositories.CustomerRepository;
import springBoot3.services.jsonPlaceHolder;

import java.util.List;

@SpringBootApplication
public class SpringBoot3Application {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository, ObservationRegistry observationRegistry) {

        return args -> {
            WebClient builder = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
            HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(builder)).build();
            jsonPlaceHolder jps = factory.createClient(jsonPlaceHolder.class);
            List<Customer> posts = /*jps.loadCustomer();*/Observation.createNotStarted("json-place-holder.load-posts", observationRegistry)
                    .lowCardinalityKeyValue("some-value", "88")
                    .observe(jps::loadCustomer);
            Observation.createNotStarted("post-repository.save-all", observationRegistry)
                    .observe(() -> repository.saveAll(posts));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Application.class, args);
    }

}
