package com.example.bulkinsert;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources", glue = "com.example.bulkinsert.hibernate.raw")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
