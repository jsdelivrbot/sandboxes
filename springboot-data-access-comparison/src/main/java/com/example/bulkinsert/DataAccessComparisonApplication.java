package com.example.bulkinsert;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class DataAccessComparisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAccessComparisonApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return (args) -> {

        };
    }
}
