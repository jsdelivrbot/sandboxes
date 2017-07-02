package com.example.bulkinsert.hibernate;


import com.example.bulkinsert.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public interface PersonDao {

    List<Person> findAllPeople();
    void createPeople(List<Person> peopleToCreate);
    void deleteAllPeople();
}
