package com.example.bulkinsert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class JpaConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.example.bulkinsert");

        //entityManagerFactoryBean.setPersistenceUnitName("raw_hibernate_persistence_unit");

        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        jpaProperties.put("hibernate.show_sql", "false");

        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        jpaProperties.put("hibernate.format_sql", "true");

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

//    @Bean
//    LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
//        //entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setPersistenceUnitName("raw_hibernate_persistence_unit");
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        //entityManagerFactoryBean.setPackagesToScan("com.example.bulkinsert");
//
//        Properties jpaProperties = new Properties();
//
//        //Configures the used database dialect. This allows Hibernate to create SQL
//        //that is optimized for the used database.
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        //Specifies the action that is invoked to the database when the Hibernate
//        //SessionFactory is created or closed.
//        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
//
//        //Configures the naming strategy that is used when Hibernate creates
//        //new database objects and schema elements
//        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
//
//        //If the value of this property is true, Hibernate writes all SQL
//        //statements to the console.
//        //jpaProperties.put("hibernate.show_sql", "true");
//
//        //If the value of this property is true, Hibernate will format the SQL
//        //that is written to the console.
//        jpaProperties.put("hibernate.format_sql", "true");
//
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
