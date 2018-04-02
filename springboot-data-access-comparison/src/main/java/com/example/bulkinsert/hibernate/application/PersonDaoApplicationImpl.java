package com.example.bulkinsert.hibernate.application;

import com.example.bulkinsert.entity.Person;
import com.example.bulkinsert.hibernate.PersonDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.*;
import java.util.List;

/**
 * A "raw" implementation which doesn't use any DI.  The Entity manager and factory are created manually, using the persistence
 * unit defined in the persistence.xml file.  Application-managed Persistence Context with "RESOURCE_LOCAL" (manual)
 * transaction management.
 */
public class PersonDaoApplicationImpl implements PersonDao {

    private EntityManager entityManager;

    PersonDaoApplicationImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("raw_hibernate_persistence_unit");
        entityManager = factory.createEntityManager();
        //factory.close();
    }

    public List<Person> findAllPeople() {
        return entityManager
                .createQuery("FROM Person", Person.class)
                .getResultList();
    }

    @Override
    public void createPeople(List<Person> peopleToCreate) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            peopleToCreate.forEach(person -> entityManager.merge(person));
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
    }

    @Override
    public void deleteAllPeople() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.createQuery("DELETE FROM Person").executeUpdate();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        }
    }
}
