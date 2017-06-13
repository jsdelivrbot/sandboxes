-- Currently this is not used as we create the database tables directly from the JPA entity definitions

CREATE TABLE person (id IDENTITY,firstname nvarchar(50),lastname nvarchar(50),ssn char(11))