package com.example.security.service;

import com.example.security.AuthorizationFilter;
import org.springframework.security.access.prepost.PreAuthorize;

public interface IService {

    @PreAuthorize("@authorizer.preAuthorize(#arg1, #arg2, #arg3)")
//    @PreAuthorize("T(com.example.springkafka.Authorizer).preAuthorize(#arg1, #arg2, #arg3)")
//    @PostAuthorize("T(com.hub.Application).postAuthorize(true)")
//    @PreFilter()
//    @PostFilter()
    String testMethodWithSpringSecurityFilter(String arg1, boolean arg2, int arg3);

    @AuthorizationFilter("@authorizer.preAuthorize(#arg1, #arg2, #arg3)")
    String testMethodWithCustomAspectHandler(String arg1, boolean arg2, int arg3);
}
