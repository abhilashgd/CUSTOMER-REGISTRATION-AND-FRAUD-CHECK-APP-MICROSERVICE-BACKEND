# Customer Registration Microservice and Fraud check microservice

**to install maven using homebrew**

                % brew install maven

**creating maven project link**

                https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

**creating a project**

                mvn archetype:generate -DgroupId=com.microservice.app -DartifactId=microservicetest -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

                //to check structure of project in terminal
                % tree
                // % brew install tree // to install tree 

**creating spring boot banners**

                https://devops.datenkollektiv.de/banner.txt/index.html
                //banner for customer
                          ,--.
,---. ,--.,--.  ,---.  ,-'  '-.  ,---.  ,--,--,--.  ,---.  ,--.--.
| .--' |  ||  | (  .-'  '-.  .-' | .-. | |        | | .-. : |  .--'
\ `--. '  ''  ' .-'  `)   |  |   ' '-' ' |  |  |  | \   --. |  |
`---'  `----'  `----'    `--'    `---'  `--`--`--'  `----' `--'

                //command to run docker-compose.yml
                % docker compose up -d
                //Command to list docker compose containers running
                % docker compose ps
                //access pgadmin
                http://localhost:5050
                create a database with name customer and another one with name fraud

**postman testing**

                URL: localhost:8080/api/v1/customers
                Body: RAW-JSON:
                {
                "firstName": "abhilash",
                "lastName": "gd",
                "email": "abhilashgd@test.com"
                }

                //inside pdadmin-> customer database->schemas->tables->customer-> select customer table, query ->select * from customers;
                //pgadmin - chech for Sequences->customer_id_sequence
                
                //inside pdadmin->fraud database-> schemas->tables->fraud-> select fraud_check_history table, query ->
                select * from fraud_check_history;
                to generate data for testing: https://www.mockaroo.com/

**Customer Microservice interacts with Fraud Check Microservice using**
                
                FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId() );
                
                //Syntax: 
                ResponseType obj=  new RestTemplate().getForObject(URL, ResponseType.class, params);

#SERVICE DISCOVERY

**Eureka Server**
        
                - Eureka clients
                - Eureka server 
                        - clients register with server and request for service location
                        - must be up and running all the time
                        - kebernetes removes the bottleneck of eureka server

                https://spring.io/-->Projects-->Spring Cloud

                Spring Cloud provides tools for developers to quickly build some of the common 
                patterns in distributed systems (e.g. configuration management, service discovery, 
                circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, 
                leadership election, distributed sessions, cluster state). Coordination of distributed systems
                leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services 
                and applications that implement those patterns. They will work well in any distributed environment, 
                including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

                //Dependency
                <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring.cloud-version}</version>
                <type>pom</type>
                <scope>import</scope>
                </dependency>

                //mention version
                <spring.cloud-version>2020.0.3</spring.cloud-version>

                //Create Eureka Server Module,
                //Add Eureka Server Dependency
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
                </dependency>

                //Eureka Server class
                annotate it with
                @SpringBootApplication
                @EnableEurekaServer
                
                //Add Application.yaml in eureka-server module
                
                //Run Eureka Server
                

