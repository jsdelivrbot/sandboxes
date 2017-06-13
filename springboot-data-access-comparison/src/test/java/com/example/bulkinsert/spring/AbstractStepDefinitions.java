package com.example.bulkinsert.spring;

import com.example.bulkinsert.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = Application.class)
@SpringBootTest
public abstract class AbstractStepDefinitions extends AbstractTestNGSpringContextTests {

}