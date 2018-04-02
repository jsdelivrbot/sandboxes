package com.example.bulkinsert.spring.data;

import com.example.bulkinsert.SampleDataCreator;
import com.example.bulkinsert.entity.Person;
import com.example.bulkinsert.AbstractStepDefinitions;
import cucumber.api.java8.En;
import org.testng.Assert;

import java.util.List;

public class SpringDataBulkInsertStepDefs extends AbstractStepDefinitions implements En {

    SpringDataBulkInsertStepDefs(PersonRepository repository) {
        Given("^A Spring Data repository$", () -> {
        });
        When("^With a repository I insert (\\d+) records into the Person table$", (Integer numRecords) -> {
            List<Person> people = new SampleDataCreator().createFakePeople(numRecords);
            repository.saveAll(people);
        });
        Then("^With a repository I verify that the (\\d+) records are inserted correctly$", (Integer numRecords) -> {
            List<Person> people = repository.findAll();
            //people.forEach(person -> System.out.println(person.toString()));
            Assert.assertEquals(people.size(), numRecords.intValue());
        });
        Then("^With a repository I clean up the Person table$", () -> {
            repository.deleteAll();

            List<Person> people = repository.findAll();
            Assert.assertEquals(people.size(), 0);
        });

    }
}
