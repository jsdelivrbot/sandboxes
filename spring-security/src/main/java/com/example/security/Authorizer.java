package com.example.security;

import org.springframework.stereotype.Component;

@Component("authorizer")
public class Authorizer {

    public boolean preAuthorize(String arg1, boolean arg2, int arg3) {
        return true;
    }
}
