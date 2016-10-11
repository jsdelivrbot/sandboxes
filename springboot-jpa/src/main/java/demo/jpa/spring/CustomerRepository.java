package demo.jpa.spring;

import demo.entity.Customer;
import demo.entity.Personality;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByPersonalitiesContaining(Personality p);
}