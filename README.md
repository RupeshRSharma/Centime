# Centime
Code problems for Centime assignment

1. There are 4 micro services in this project - Micro service 1 (Port: 8080), Micro service 2(Port: 8081), Micro service 3(Port: 8082), Micro service 4(Port: 8083)
2. Micro service 1, Micro service 2, Micro service 3 are part of **Task 1** and Micro service 4 is part of **Task 2**
3. All the Micro services are built using **Java 8**, **Spring boot version 2.3.1** and **Apache Maven 3.6.2** 
4. Run using command **mvn spring-boot:run** from the respective Micro service parent directory, for eg. `cd ~\Centime\Microservice1`
5. Micro service 1 and Micro service 4 have Swagger UI
6. Swagger UI link for Microservice 1 to verify Task 1 - http://localhost:8080/swagger-ui.html#
7. Swagger UI link for Microservice 4 to verify Task 2 - http://localhost:8083/swagger-ui.html#

#####Assumptions:
1. Micro services are not hosted on AWS, they use localhost to communicate with each other for Task 1
2. Eureka can be used for service discovery if needed or Micro servies can communicate via ALB URLs
3. No security framework is present to secure Micro servcies
4. Test cases are not present
5. For log tracing, Sleuth has been used in Micro services 1/2/3 but Zipkin is not used to look at them
6. H2 in-memeory database is used for Task 2 in Micro service 4
7. Exception hanlding is being where it was asked for, not at all places
8. Logging is minimal as needed
9. Lombok had issues with IDE, so Lombok dependency and annotations are present but not used

##Microservice Design Problem Statement 
Use SpringBoot version 2+, Host below microservices in a aws free tier account.

###TASK 1  

Goal: Create a three service microservice project to demonstrate orchestration, rest api invocation, error handling, tracing of logs in javaEE or Node.js Services should communicate with aws hosted URLs


1st Service) Expose two http methods, one get and one post (add swaggerUI).
From the get method return “Up” if service is up. The post method should return the concatenated responses of the Get call of Service 2 and the Post call of Service 3 using the same payload({The json})

2nd Service) It contains one get method which is called by the first service to fetch a string”Hello” wrapped with a spring response entity.

3rd Service) This exposes one post method which is called by first service to print/log the passed json and return the concatenated name elements as a string (example - “John Doe”) 

Print logs before each method call with a traceID to trace the call flow. 

The json.
{
“Name”: “John”,
“Surname”:”Doe”
} 

Concatenated Response :-
{
“Hello John Doe”
}

Extra: Handle exception when passed Json in post calls is not valid

###TASK 2

Create 
Db Connection: 
Host a database in local or aws (postgres or mysql or inmemory db(H2)).
Configure your microservice to connect to db.
Create Hibernate Entity Class  based on the below table requirement to auto create tables in hosted db.
Populate the db from a post request with the below data or directly insert into db.

Expose endpoints to fetch requests based on Id and complete list of objects.
While getting the complete table, Modify the result set(arrays or list) to form nested object structure.
Below is the nested output in json.Associate color to each object according to table.

Create a table with fields ID, Name, Color, ParentId and populate with below data.

| id | parentid | name    					| color      |
|:--:|:--------:|:-------------------------:|:----------:|
| 1  | 0 		| Warrior 					| red        |
| 2  | 0 		| Wizard 					| green      |
| 3  | 0 		| Priest 					| white      |
| 4  | 0 		| Rogue 					| yellow     |
| 5  | 1 		| Fighter 					| blue       |
| 6  | 1 		| Paladin 					| lighblue   |
| 7  | 1 		| Ranger 					| lightgreen |
| 8  | 2 		| Mage 						| grey       |
| 9  | 2 		| Specialist wizard 		| lightgrey  |
| 10 | 3 		| Cleric 					| red        |
| 11 | 3 		| Druid 					| green      |
| 12 | 3 		| Priest of specific mythos | white      |
| 13 | 4 		| Thief 					| yellow     |
| 14 | 4 		| Bard 						| blue       |
| 15 | 13 		| Assassin 					| lighblue   |


Nested Json response. Ignore Dangling Branches Scenario.

[
  {
    "Name": "Wizard",
    "Sub Classes": [
      {
        "Name": "Mage"
      },
      {
        "Name": "Specialist wizard"
      }
    ]
  },
  {
    "Name": "Priest",
    "Sub Classes": [
      {
        "Name": "Cleric"
      },
      {
        "Name": "Druid"
      },
      {
        "Name": "Priest of specific mythos"
      }
    ]
  },
  {
    "Name": "Warrior",
    "Sub Classes": [
      {
        "Name": "Fighter"
      },
      {
        "Name": "Paladin"
      },
      {
        "Name": "Ranger"
      }
    ]
  },
  {
    "Name": "Rogue",
    "Sub Classes": [
      {
        "Name": "Thief",
        "Sub Classes": [
          {
            "Name": "Assassin"
          }
        ]
      },
      {
        "Name": "Bard"
      }
    ]
  }
]

    
Create a method level Annotation @LogMethodParam which logs parameters passed to method.

