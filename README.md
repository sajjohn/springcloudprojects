# MicroServices POC

This is a POC demonstrating Microservices architecture using Spring Cloud & Netflix OSS. An angular based UI application consumes the microservices (https://github.com/sajjohn/angularprojects) </br></br>.

   
# Notes

- The entry point for the application is API gateway . Here we are using Netflix's Zuul Proxy as our API gateway.
- All request from browser have to be authenticated for API access . We are using OAuth 2.0 Authorization Code workflow & JWT based authentication.
- The property configuration for all components are externalized using Spring Cloud config server.
- All services are registered to Eureka Service discovery.
- Hystrix is used as a circuit breaker & services communicate with each using Feign Client.
- The Backend services spit out the metrics stream to Turbine which aggregates all the metrics information coming from hystrix.
- A hystrix dashboard present monitoring information on a real time basis in order to visulaize health of the application.

# About Application

The application is simple CRUD based. A service which fetches the list of Employess, Add New Employees, Updates & Deletes existing employee.
EmployeeDashboard acts as a delegate for the Employee service, this has been demonstrated to show how Hystrix , Ribbon & Feign clients are leveraged.

## Build & Run

Run mvn clean install from the root folder . It will install all applications.

To run the services go to individual services & run the maven command.

mvn sping-boot-run
 
Once all applications have been started. Load the Eureka URl

http://localhost:8761/

Link for the Metrics Dashboard

http://localhost:8990/hystrix

Use the Turbine metrics link (http://localhost:8989/turbine/turbine.stream) in the text box .

## To Be Implemented in near future.

- Exception Handling.
- Integration Test Cases.
- Distributed Logging using SLeuth & integration with ELK.
- DOcker containerization & CI CD setup.






