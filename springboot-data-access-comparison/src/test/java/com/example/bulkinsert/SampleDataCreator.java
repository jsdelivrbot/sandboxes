package com.example.bulkinsert;


import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleDataCreator {

    private final Faker faker = new Faker(new Random(1));

    public Person createFakePerson() {
        Person person = new Person();
        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().firstName());
        person.setSocialSecurityNumber(faker.idNumber().ssnValid());

        return person;
    }

    public List<Person> createFakePeople(int numPeople) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            people.add(createFakePerson());
        }

        return people;
    }
}
