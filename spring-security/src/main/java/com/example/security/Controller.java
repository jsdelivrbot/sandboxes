package com.example.security;

import com.example.security.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    public IService service;

    @RequestMapping("/securityFilter/{testParam}")
    public void testSecurityFilter(@PathVariable String testParam) {
        service.testMethodWithSpringSecurityFilter(testParam, true, 5);
    }

    @RequestMapping("/aspectHandler/{testParam}")
    public void testAspectHandleer(@PathVariable String testParam) {
        service.testMethodWithCustomAspectHandler(testParam, true, 5);
    }
}
