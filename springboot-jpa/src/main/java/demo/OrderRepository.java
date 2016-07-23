package demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OrderRepository //extends PagingAndSortingRepository<Customer, Long> {
		extends JpaRepository<Order, Long>, QueryDslPredicateExecutor<Order> {


}
