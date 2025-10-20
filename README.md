# Demo

Steps to run the program:

test change

1) Take demo.zip and unzip it.
2) Open the project with IDE.
3) Run project as a spring-boot application or perform the command "mvn clean spring-boot:run"
4) Embedded Tomcat will be started on port: 8080 and application will be available on http://localhost:8080/
5) H2 in-memory database was chosen as a  persistency mechanism. Web view for DB will be available on http://localhost:8080/h2-console/
   Login: test, Password: 123
6) Since I used H2 DB which provides the possibility to prepopulate tables with some data by creation data.sql file. I decided to do it this way for "Generate Retailers" task, just to save time.
   Another way of doing that can be custom CommandLineRunner.
7) API for increasing stock level accepts retailerName parameter with values: RET_A and RET_B instead of RetA and RetB accordingly. Wrapped it with ENUM.
   Also, an update query can be done by using join instead of subselecting, but it's a limitation from H2 DB. It doesn't have such a possibility.
