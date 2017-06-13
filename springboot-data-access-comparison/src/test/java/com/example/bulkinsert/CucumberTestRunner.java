package com.example.bulkinsert;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources", glue = "com.example.bulkinsert")
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
