package org.mybiz;


import java.util.Collection;

public class Organization {
    private final long id;
    private final Collection<Employee> employees;

    public Organization(long id, Collection<Employee> employees) {
        this.id = id;
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }
}
