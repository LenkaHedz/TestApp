# FINAL PROJECT: Fast Student Testing System

A student has to registered by e-mail. The results of the test will be sent on that e-mail. 
The system contains a catalog of tests by topics. An authorized student can pass the tests. 
When test are complete the student is shown the page with all the errors.
All the data on academic progress and completed courses are displayed on the Administrator page as a summary table for all Students.

Application Architecture
- MVC. Webapp
- Used templates: GoF (e.g. Builder, Singleton, Command, AbstractFactory)
- The application is built using Apache Maven
- Server to run - Apache Tomcat

Technologies used:
- JSP + JSTL
- Servlets + Filters
- Session
- MySQL JDBC
- Log4J2
- JUnit
- Pagination
- Transaction

MySQL DB Dump: Dump20180522.sql

Run/Deug Configurations: Maven 
Command line: tomcat7:run
