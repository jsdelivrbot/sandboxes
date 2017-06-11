Feature: BulkInsert

  Scenario:
    Given A Spring JDBC datasource
    When I insert 5000 records into the Person table
    Then I verify that the 5000 records are inserted correctly