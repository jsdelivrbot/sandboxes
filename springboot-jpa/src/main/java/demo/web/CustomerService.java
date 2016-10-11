package demo.web;

import demo.entity.Customer;
import demo.jpa.spring.CustomerRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    Iterable<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Customer getCustomerById(@PathVariable Long id) {
        return repository.findOne(id);
    }
}
