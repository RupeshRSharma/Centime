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

