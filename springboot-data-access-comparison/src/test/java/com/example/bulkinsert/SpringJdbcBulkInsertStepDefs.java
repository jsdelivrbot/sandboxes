package com.example.bulkinsert;

import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@ContextConfiguration(classes = DataSourceConfig.class)
@SpringBootTest
public class SpringJdbcBulkInsertStepDefs extends AbstractTestNGSpringContextTests implements En {

    //@Autowired
   // private DataSource dataSource;

    private JdbcTemplate template;

   // @Autowired
    public SpringJdbcBulkInsertStepDefs(/*DataSource dataSource*/) {
    //public SpringJdbcBulkInsertStepDefs() {
        Given("^A Spring JDBC datasource$", () -> {
            DataSourceConfig config = new DataSourceConfig();
            template = new JdbcTemplate(config.dataSource());
            //template = new JdbcTemplate(dataSource);
        });
        When("^I insert (\\d+) records into the Person table$", (Integer numRecords) -> {
//            String updatePersonSql = "INSERT INTO PERSON (firstname,lastname,ssn) VALUES (?,?,?)";
            String updatePersonSql = "INSERT INTO PERSON VALUES (?,?,?)";

            List<Person> people = new SampleDataCreator().createFakePeople(numRecords);

            template.batchUpdate(updatePersonSql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Person person = people.get(i);
                    ps.setString(1, person.getFirstName());
                    ps.setString(2, person.getLastName());
                    ps.setString(3, person.getSocialSecurityNumber());
                }

                @Override
                public int getBatchSize() {
                    return people.size();
                }
            });
        });
        Then("^I verify that the (\\d+) records are inserted correctly$", (Integer numRecords) -> {
            String selectPersonSql = "SELECT * FROM PERSON";

            List<Person> people = template.query(
                    selectPersonSql,
                    (rs, rowNum) -> {
                        Person person = new Person();
                        person.setFirstName(rs.getString("firstname"));
                        person.setLastName(rs.getString("lastname"));
                        person.setSocialSecurityNumber(rs.getString("ssn"));
                        return person;
                    }
            );

            Assert.assertEquals(people.size(), numRecords.intValue());
        });
    }
}
