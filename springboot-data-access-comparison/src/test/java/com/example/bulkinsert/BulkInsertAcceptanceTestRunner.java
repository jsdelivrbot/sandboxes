package com.example.bulkinsert;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * This is a Cucumber test runner
 */
@CucumberOptions(features = "src/test/resources/BulkInsert.feature", glue = "com.example.bulkinsert")
public class BulkInsertAcceptanceTestRunner extends AbstractTestNGCucumberTests {

}