package demo;

import com.google.common.collect.Lists;
import demo.entity.Customer;
import demo.entity.Order;
import demo.entity.Personality;
import demo.jpa.spring.CustomerRepository;
import demo.jpa.spring.OrderRepository;
import demo.jpa.spring.PersonalityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@SpringBootApplication
@EnableTransactionManagement
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

//	@Bean
//	public CommandLineRunner demo(PlatformTransactionManager manager,
//								  CustomerRepository customerRepository,
//								  PersonalityRepository personalityRepository) {
//		return (args) -> {
//			junctionDemo(manager, customerRepository, personalityRepository);
//		};
//	}

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

	//@Transactional(transactionManager = "PlatformTransactionManager")
	private void junctionDemo(PlatformTransactionManager manager,
							  CustomerRepository customerRepository, PersonalityRepository personalityRepository) {
		Iterable<Personality> personalities = personalityRepository.findAll();
		ArrayList<Personality> personalitiesToAdd = Lists.newArrayList(personalities);

		Collection<Customer> newCustomers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {

			Customer customerToAdd = new Customer(Integer.toString(i), Integer.toString(i),
					personalitiesToAdd);
			newCustomers.add(customerToAdd);
		}
		customerRepository.save(newCustomers);

		TransactionTemplate transactionTemplate = new TransactionTemplate(manager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				Iterable<Customer> retrievedCustomers = customerRepository.findAll();
				for (Customer customer : retrievedCustomers) {
					log.info("Personalities: ");
					for (Personality personality : customer.getPersonalities()) {
						log.info("	" + personality.toString());
					}
				}
			}
		});
	}

//	private void simpleDemo(CustomerRepository customerRepository, OrderRepository orderRepository) {
//		// save a couple of customers
//		customerRepository.save(new Customer("Jack", "Bauer"));
//		customerRepository.save(new Customer("Chloe", "O'Brian"));
//		customerRepository.save(new Customer("Kim", "Bauer"));
//		customerRepository.save(new Customer("David", "Palmer"));
//		customerRepository.save(new Customer("Michelle", "Dessler"));
//
//		orderRepository.save(new Order(1, "test order1"));
//		orderRepository.save(new Order(2, "test order2"));
//		orderRepository.save(new Order(3, "test order3"));
//		orderRepository.save(new Order(4, "test order4"));
//
//		// fetch all customers
//		log.info("Customers found with findAll():");
//		log.info("-------------------------------");
//		for (Customer customer : customerRepository.findAll()) {
//			log.info(customer.toString());
//		}
//		log.info("");
//
//		// fetch an individual customer by ID
//		Customer customer = customerRepository.findOne(1L);
//		log.info("Customer found with findOne(1L):");
//		log.info("--------------------------------");
//		log.info(customer.toString());
//		log.info("");
//
//		// fetch customers by last name
//		log.info("Customer found with findByLastName('Bauer'):");
//		log.info("--------------------------------------------");
//		for (Customer bauer : customerRepository.findByLastName("Bauer")) {
//			log.info(bauer.toString());
//		}
//		log.info("");
//
//		// fetch customers by last name
//		log.info("Customer found with findByFirstName('Kim'):");
//		log.info("--------------------------------------------");
//		for (Customer bauer : customerRepository.findByFirstName("Kim")) {
//			log.info(bauer.toString());
//		}
//		log.info("");
//	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://ROCKMAN-PC:1433;databaseName=SpringBoot;");
		dataSource.setUsername( "sa" );
		dataSource.setPassword( "blue" );
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(false);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("demo");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}