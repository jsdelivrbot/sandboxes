package com.example.bulkinsert.jdbc;

import com.example.bulkinsert.AbstractStepDefinitions;
import com.example.bulkinsert.SampleDataCreator;
import com.example.bulkinsert.entity.Person;
import cucumber.api.java8.En;
import org.h2.command.Prepared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.testng.Assert;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

public class PlainJdbcBulkInsertStepDefs extends AbstractStepDefinitions implements En {

    private JdbcTemplate template;

    private static final String INSERT_PERSON_RECORD = "INSERT INTO Person (firstname, lastname, ssn) VALUES (?,?,?)";
    private static final String SELECT_ALL_PEOPLE = "SELECT * FROM Person";
    private static final String DELETE_ALL_PEOPLE_RECORDS = "DELETE Person";

    @Autowired
    public PlainJdbcBulkInsertStepDefs(DataSource h2DataSource) throws SQLException {
        Given("^A Plain JDBC datasource$", () -> template = new JdbcTemplate(h2DataSource));
        When("^I insert (\\d+) records into the Person table$", (Integer numRecords) -> {
            List<Person> people = new SampleDataCreator().createFakePeople(numRecords);
            try {
                PreparedStatement statement = h2DataSource.getConnection().prepareStatement(INSERT_PERSON_RECORD);
                for (Person person : people) {
                    statement.setString(1, person.getFirstName());
                    statement.setString(2, person.getLastName());
                    statement.setString(3, person.getSocialSecurityNumber());
                    statement.addBatch();
                }
                statement.executeBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

//            template.batchUpdate(INSERT_PERSON_RECORD, new BatchPreparedStatementSetter() {
//                @Override
//                public void setValues(PreparedStatement ps, int i) throws SQLException {
//                    Person person = people.get(i);
//                    ps.setString(1, person.getFirstName());
//                    ps.setString(2, person.getLastName());
//                    ps.setString(3, person.getSocialSecurityNumber());
//                }
//
//                @Override
//                public int getBatchSize() {
//                    return people.size();
//                }
//            });
        });
        Then("^I verify that the (\\d+) records are inserted correctly$", (Integer numRecords) -> {
            List<Person> people = template.query(
                    SELECT_ALL_PEOPLE,
                    (rs, rowNum) -> {
                        Person person = new Person();
                        person.setFirstName(rs.getString("firstname"));
                        person.setLastName(rs.getString("lastname"));
                        person.setSocialSecurityNumber(rs.getString("ssn"));
                        return person;
                    }
            );

            people.forEach(person -> System.out.println(person.toString()));

            Assert.assertEquals(people.size(), numRecords.intValue());
        });
        Then("^I clean up the Person table$", () -> {
            template.execute(DELETE_ALL_PEOPLE_RECORDS);

            RowCountCallbackHandler rowCountCallbackHandler = new RowCountCallbackHandler();
            template.query(SELECT_ALL_PEOPLE, rowCountCallbackHandler);
            Assert.assertEquals(rowCountCallbackHandler.getRowCount(), 0);
        });
    }
}
