package com.example.bulkinsert.hibernate.spring;

import com.example.bulkinsert.entity.Person;
import com.example.bulkinsert.hibernate.PersonDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class PersonDaoSpringImpl implements PersonDao {

    private HibernateTemplate hibernateTemplate;

    public List<Person> findAllPeople() {
        return hibernateTemplate.loadAll(Person.class);
    }

    @Override
    public void createPeople(List<Person> peopleToCreate) {

    }

    @Override
    public void deleteAllPeople() {

    }
}
