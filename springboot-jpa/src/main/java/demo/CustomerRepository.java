package demo;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstName(String firstName);
}