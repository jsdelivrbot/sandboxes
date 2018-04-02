package com.example.bulkinsert.hibernate.application;

import com.example.bulkinsert.AbstractStepDefinitions;
import com.example.bulkinsert.SampleDataCreator;
import com.example.bulkinsert.entity.Person;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.List;

/**
 * Tests JPA without any fancy dependency injection.
 */
public class HibernateApplicationBulkInsertStepDefs extends AbstractStepDefinitions implements En {

    private PersonDaoApplicationImpl dao = new PersonDaoApplicationImpl();

    HibernateApplicationBulkInsertStepDefs() {
        Given("^An application-managed entity manager$", () -> {
        });
        Then("^With an application-managed entity manager I insert (\\d+) records into the Person table$", (Integer numRecords) -> {
            List<Person> people = new SampleDataCreator().createFakePeople(numRecords);

            dao.createPeople(people);
        });
        Then("^With an application-managed entity manager I verify that the (\\d+) records are inserted correctly$", (Integer numRecords) -> {
            List<Person> people = dao.findAllPeople();

            Assert.assertEquals(people.size(), numRecords.intValue());
        });
        Then("^With an application-managed entity manager I clean up the Person table$", () -> {
            dao.deleteAllPeople();

            List<Person> people = dao.findAllPeople();
            Assert.assertEquals(people.size(), 0);
        });

    }
}
