package com.example.security.service;

import com.example.security.AuthorizationFilter;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements IService {

    public String testMethodWithSpringSecurityFilter(String arg1, boolean arg2, int arg3) {
        return "success";
    }

    @Override
    @AuthorizationFilter("@authorizer.preAuthorize(#arg1, #arg2, #arg3)")
    public String testMethodWithCustomAspectHandler(String arg1, boolean arg2, int arg3) {
        return "success";
    }
}
