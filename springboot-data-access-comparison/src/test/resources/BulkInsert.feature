Feature: BulkInsert

  Scenario:
    Given A Spring JDBC datasource
    When I insert 5000 records into the Person table
    Then I verify that the 5000 records are inserted correctly
    Then I clean up the Person table

  Scenario:
    Given A Spring Data repository
    When With a repository I insert 5000 records into the Person table
    Then With a repository I verify that the 5000 records are inserted correctly
    Then With a repository I clean up the Person table