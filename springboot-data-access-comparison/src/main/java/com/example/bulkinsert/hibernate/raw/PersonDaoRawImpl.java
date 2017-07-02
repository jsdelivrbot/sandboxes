package com.example.bulkinsert.hibernate.raw;

import com.example.bulkinsert.entity.Person;
import com.example.bulkinsert.hibernate.PersonDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * A "raw" implementation which doesn't use any DI.  The Entity manager and factory are created manually, using the persistence
 * unit defined in the persistence.xml file.
 */
public class PersonDaoRawImpl implements PersonDao {

    private EntityManager entityManager;

    PersonDaoRawImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("raw_hibernate_persistence_unit");
        entityManager = factory.createEntityManager();
    }

    //TODO: add create/delete methods
    //TODO: transactions

    public List<Person> findAllPeople() {
        return entityManager
                .createQuery("FROM Person", Person.class)
                .getResultList();
    }

    @Override
    public void createPeople(List<Person> peopleToCreate) {

    }

    @Override
    public void deleteAllPeople() {

    }
}
