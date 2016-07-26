package demo;

import com.google.common.base.Stopwatch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HibernateTest {

//	protected SessionFactory newSessionFactory() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//		//log settings
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		properties.put("hibernate.show_sql", "true");
//		//driver settings
//		properties.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
//		properties.put("hibernate.connection.url", "jdbc:hsqldb:mem:test");
//		properties.put("hibernate.connection.username", "sa");
//		properties.put("hibernate.connection.password", "");
//
//		return new Configuration()
//				.addProperties(properties)
//				.addAnnotatedClass(Customer.class)
//				.buildSessionFactory(
//						new StandardServiceRegistryBuilder()
//								.applySettings(properties)
//								.build()
//				);
//	}

	protected SessionFactory newSessionFactory() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		//log settings
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		//driver settings
		properties.put("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		properties.put("hibernate.connection.url", "jdbc:sqlserver://ROCKMAN-PC:1433;databaseName=SpringBoot;");
		properties.put("hibernate.connection.username", "sa");
		properties.put("hibernate.connection.password", "blue");

		return new Configuration()
				.addProperties(properties)
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory(
						new StandardServiceRegistryBuilder()
								.applySettings(properties)
								.build()
				);
	}

	@Test
	public void test() {
		Session session = null;
		Transaction txn = null;
		try {
			session = newSessionFactory().openSession();
			txn = session.beginTransaction();

			Stopwatch sw = Stopwatch.createStarted();
			System.out.println("performanceTestHibernate: Starting save of 100,000 records");

			for (int i = 0; i < 100000; i++) {
				session.persist(new Customer(Integer.toString(i), Integer.toString(i)));
			}

			System.out.println("Total time to save 100,000 records: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");

			sw.reset();
			sw.start();
			List<Customer> customers = session.createCriteria(Customer.class).list();
			sw.stop();
			System.out.println("Total time to load 100,000 records: " + sw.elapsed(TimeUnit.MILLISECONDS) + " ms");

			txn.commit();
		} catch (RuntimeException e) {
			if (txn != null && txn.getStatus().canRollback()) {
				txn.rollback();
			}
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
