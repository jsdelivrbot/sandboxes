package org.mybiz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public class EmployeeService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee get() {
        return new Employee(1, "John Doe");
    }
}
