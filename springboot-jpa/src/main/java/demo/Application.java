package demo;

import demo.entity.Customer;
import demo.entity.Order;
import demo.jpa.spring.CustomerRepository;
import demo.jpa.spring.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.util.StopWatch;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Inject
	private LocalContainerEntityManagerFactoryBean b;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, OrderRepository orderRepository) {
		return (args) -> {

			//performanceTestSpringJpa(customerRepository, orderRepository);
			//performanceTestHibernate();
		};
	}

	private void performanceTestSpringJpa(CustomerRepository customerRepository, OrderRepository orderRepository) {

		StopWatch sw = new StopWatch();
		sw.start("Create records");
		log.info("performanceTestSpringJpa: Starting save of 100,000 records");

		//Inserting individually runs at least 3x slower...
//		for (int i = 0; i < 100000; i++) {
//			customerRepository.save(new Customer("1", "1"));
//		}
		Collection<Customer> newCustomers = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			newCustomers.add(new Customer(Integer.toString(i), Integer.toString(i)));
		}
		customerRepository.save(newCustomers);
		sw.stop();
		log.info("Total time to save 100,000 records: " + sw.getLastTaskTimeMillis() + " ms");

		sw.start("Load records");
		Iterable<Customer> customers = customerRepository.findAll();
		sw.stop();
		log.info("Total time to load 100,000 records: " + sw.getLastTaskTimeMillis() + " ms");
	}

//	private void performanceTestHibernate() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CustomerService");
//		EntityManager manager = factory.createEntityManager();
//		CustomerService cs = new CustomerService(manager);
//
//		StopWatch sw = new StopWatch();
//		sw.start("Create records");
//		log.info("performanceTestHibernate: Starting save of 100,000 records");
//
//		for (int i = 0; i < 100000; i++) {
//			cs.createCustomer(new Customer("1", "1"));
//		}
//		sw.stop();
//		log.info("Total time to save 100,000 records: " + sw.getLastTaskTimeMillis() + " ms");
//
//		sw.start("Load records");
//		List<Customer> customers = cs.findAllCustomers();
//		sw.stop();
//		log.info("Total time to load 100,000 records: " + sw.getLastTaskTimeMillis() + " ms");
//	}

	private void simpleDemo(CustomerRepository customerRepository, OrderRepository orderRepository) {
		// save a couple of customers
		customerRepository.save(new Customer("Jack", "Bauer"));
		customerRepository.save(new Customer("Chloe", "O'Brian"));
		customerRepository.save(new Customer("Kim", "Bauer"));
		customerRepository.save(new Customer("David", "Palmer"));
		customerRepository.save(new Customer("Michelle", "Dessler"));

		orderRepository.save(new Order(1, "test order1"));
		orderRepository.save(new Order(2, "test order2"));
		orderRepository.save(new Order(3, "test order3"));
		orderRepository.save(new Order(4, "test order4"));

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
	}
}