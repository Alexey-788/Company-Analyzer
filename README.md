# Company-Analyzer

## About

This project was created on technical assignment. Its goal is to give API for simultaneous access to both the financial information of the company and the vacancies of the company. A comparison of this information gives more in the selection of work.

## Technologies

Used technologies:
* Web: Spring Web
* Database: H2
* ORM: Hibernate(Spring Data)
* Test: JUnit5, Mockito
* Parsing: Jsoup, Json-Simple

## Launch

Maven:

$ mvn spring-boot:run

Or with your IDE.

## Web end-points

By default, application starts at http://localhost:8080/

There are end-points:
* /company/list - list of companies
* /company/{companyId} - more information about a company
* /vacancy/page/{page}/company/{companyId} - page of vacancies of provided company