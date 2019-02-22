Publish-Subscribe is Spring boot app with H2 db in memory and Maven.

Run as: mvn clean install spring-boot:run

Access the H2 console:
http://localhost:9080/h2-console
jdbc url: jdbc:h2:mem:publish-subscribe

The main URL to access the project is:
http://localhost:9080/

Subscriber services:

Put
http://localhost:9080/subscriber/create

Get
http://localhost:9080/subscriber/{id}

Get
http://localhost:9080/subscriber/all