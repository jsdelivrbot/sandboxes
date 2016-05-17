package org.example.service;

import org.example.model.Employee;
import org.example.model.Organization;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Path("/organization")
public class OrganizationService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Organization get() {
        Employee emp1 = new Employee(1, "John Doe");
        Employee emp2 = new Employee(2, "Jane Shmoe");
        Collection<Employee> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);

        Organization org = new Organization();
        org.setId((long)3);
        org.setEmployees(emps);
        return org;
    }
}
