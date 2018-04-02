Feature: BulkInsert

  Scenario:
    Given A Spring JDBC datasource
    Then I insert 50000 records into the Person table
    Then I verify that the 50000 records are inserted correctly
    Then I clean up the Person table

  Scenario:
    Given A Spring Data repository
    Then With a repository I insert 50000 records into the Person table
    Then With a repository I verify that the 50000 records are inserted correctly
    Then With a repository I clean up the Person table

  Scenario:
    Given An application-managed entity manager
    Then With an application-managed entity manager I insert 50000 records into the Person table
    Then With an application-managed entity manager I verify that the 50000 records are inserted correctly
    Then With an application-managed entity manager I clean up the Person table