package org.example.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greeting")
public class GreeterService {

    @GET
    public String sayHi() {
        return "Hi!dfgdfgdfgdfghjghj1122g";
    }
}
