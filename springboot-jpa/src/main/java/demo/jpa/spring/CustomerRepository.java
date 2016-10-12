package demo.jpa.spring;

import demo.entity.Customer;
import demo.entity.Personality;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    //Used an EntityGraph to enable JOINS in the query for retrieving customers and the related personalities
    // all in one query, avoiding the N+1 problem
    @EntityGraph(value = "Customer.detail", type = EntityGraphType.LOAD)
    //TODO: try the same thing, using a Hibernate fetch profile below instead of EntityGraph
    //@Query(value = "SELECT c FROM Customer c LEFT JOIN FETCH p.author LEFT JOIN FETCH p.city c LEFT JOIN FETCH c.state where p.id = :id")
    List<Customer> findAll();

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByPersonalitiesContaining(Personality p);
}