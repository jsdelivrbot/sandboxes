package demo;

import com.mysema.query.jpa.impl.JPAQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, OrderRepository orderRepository) {
		return (args) -> {

			//JPAQuery query = new JPAQuery(orderRepository);
			orderRepository.save(new Order(1, "test order1"));
			orderRepository.save(new Order(2, "test order2"));
			orderRepository.save(new Order(3, "test order3"));
			orderRepository.save(new Order(4, "test order4"));

			//QOrder.order.

			// save a couple of customers
			customerRepository.save(new Customer("Jack", "Bauer"));
			customerRepository.save(new Customer("Chloe", "O'Brian"));
			customerRepository.save(new Customer("Kim", "Bauer"));
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : customerRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customerRepository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : customerRepository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByFirstName('Kim'):");
			log.info("--------------------------------------------");
			for (Customer bauer : customerRepository.findByFirstName("Kim")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}