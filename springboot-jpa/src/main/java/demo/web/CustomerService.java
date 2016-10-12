package demo.web;

import demo.entity.Customer;
import demo.entity.Personality;
import demo.jpa.spring.CustomerRepository;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    Iterable<Customer> findAllCustomers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Customer findCustomerById(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(path = "/newSchizo", method = RequestMethod.GET)
    Customer generateNewSchizoCustomer() {
        return generateNewRandomCustomerWithPersonality(Personality.SCHIZOPHRENIC);
    }

    @RequestMapping(path = "/emo", method = RequestMethod.GET)
    List<Customer> findAllEmoCustomers() {
        return repository.findByPersonalitiesContaining(Personality.EMO);
    }

    @RequestMapping(path = "/newEmo", method = RequestMethod.GET)
    Customer generateNewEmoCustomer() {
       return generateNewRandomCustomerWithPersonality(Personality.EMO);
    }

    private Customer generateNewRandomCustomerWithPersonality(Personality personality) {
        Customer customer = new Customer("firstName_" + UUID.randomUUID().toString().substring(0, 8),
                "lastName_" + UUID.randomUUID().toString().substring(0, 8), Collections.singleton(personality));
        return repository.save(customer);
    }
}
