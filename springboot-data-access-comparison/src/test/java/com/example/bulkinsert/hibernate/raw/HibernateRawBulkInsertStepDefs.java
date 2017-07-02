package com.example.bulkinsert.hibernate.raw;

import com.example.bulkinsert.AbstractStepDefinitions;
import com.example.bulkinsert.SampleDataCreator;
import com.example.bulkinsert.entity.Person;
import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.List;

/**
 * Tests JPA without any fancy dependency injection.
 */
public class HibernateRawBulkInsertStepDefs extends AbstractStepDefinitions implements En {

    private PersonDaoRawImpl dao = new PersonDaoRawImpl();

    HibernateRawBulkInsertStepDefs() {
        Given("^A JPA entity manager$", () -> {
        });
        Then("^With an entity manager I insert (\\d+) records into the Person table$", (Integer arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^With an entity manager I verify that the (\\d+) records are inserted correctly$", (Integer arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^With an entity manager I clean up the Person table$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
