# Assignment 2: Java Backend

REST API's using Spring Boot for two models Team and Player.

I have created REST APIs for two models i.e., Team and Player using Spring Boot to perform CRUD operation. These models have one to many relationships and below is the ER diagram for the same.
![image](https://user-images.githubusercontent.com/46108315/159164958-9b93d15c-688f-4ba5-acc2-7811b5edbd05.png)
  
# Tool/Platform used
-	Java
-	Spring Boot Framework
-	Maven
-	MySQL
-	Eclipse IDE
-	Postman

To create above spring boot project, I have used spring initializr tool which provides basic structure of spring boot project to get started.

For this project, I have added following dependencies:
-	Spring boot DevTools – Provides Development Tools
-	Spring Web – For building restful web application
-	MySQL Driver – For JDBC Driver
-	Spring data JPA – Java persistence API and Hibernate which requires to access the data from database.

![image](https://user-images.githubusercontent.com/46108315/159165275-5c144e3a-8ee6-4670-934a-cb6c644b4815.png)

 
# Below is Folder structure of zip the extracted folder generated from spring initializr.
![image](https://user-images.githubusercontent.com/46108315/159165332-bf5eeb23-0771-4f4a-a8d3-83c814d15f30.png)
 
In above folder, TeamPlayerApplication.java is the main file that will launch the Spring Boot Application. The application.properties file is use to configure the application. Configuration such as database URL, username, password. Pom.xml contains all the dependencies that I have added while creating the Spring Boot project in Spring Initializr. I have created sub packages for each of MVC (Model-View-Controller) layers in the project.

-	Controller – This is top most layer which is called when a request come for a particular REST API and returns an HTTP response to the client. It acts as bridge between view and model.
-	Model – This contains all java objects which is mapped with database table.
-	Repository – This is similar to DAO (Data Access Object) which is use to connect to the database and accesses the data. 
-	Service – This layer calls the repository to get the data and perform logic like calculations on data received, filtering data based on some logic, etc.


# Below is the architecture of spring MVC:

![image](https://user-images.githubusercontent.com/46108315/159165386-84b9be3c-73ae-4e44-81d8-a4ad2d36e6db.png)
 
			                            Controller-Service-Repository Architecture
           
# Following are (CRUD) endpoints in spring boot
1.	Create - Team, Player
2.	Find by Id - Team, Player
3.	update - Team, Player
4.	delete - Team, Player
5.	Find players by team id and Find team by player id

# Create
# Team
To create a Team, I have sent POST request for the URL https://localhost:8080/api/team. In the URL, I have given RequestMapping as “/api/team” which is working for create endpoint and it is preceded by server and port. Here server is localhost and port are 8080.

@RequestMapping annotation in the class which comes under Controller package defines a base URL for all the REST APIs created in the controller. This base URL is followed by individual REST endpoints given to each of the controller method.
![image](https://user-images.githubusercontent.com/46108315/159165566-0cbed676-517a-49ef-9b69-aad198d45d47.png)
 
Entered below data to send request body to the given URL endpoint. These are the Team data that will be inserted into the database.

![image](https://user-images.githubusercontent.com/46108315/159165576-9e383b74-05ed-4e60-be8c-69abc1c3ff0c.png)
 
After clinking on send button it will return the response body is a JSON containing the team record details which will save in the database.

Below is the image of before sending POST request to create team.

![image](https://user-images.githubusercontent.com/46108315/159165594-a56acd6d-29e1-4d8b-88b3-ee38845647d1.png)
 
Below is the image of after sending POST request and getting response of created team.

![image](https://user-images.githubusercontent.com/46108315/159165662-9f70b071-7867-43aa-af72-1ab89faa993f.png)
 
The created team data has been saved in database as shown in below.

![image](https://user-images.githubusercontent.com/46108315/159165667-976646b4-6c9b-4db9-af72-c30124c17afe.png)
 
# Player

Similarly, to create a Player, I have sent POST request for the URL https://localhost:8080/api/team/40/player. In the URL, 40 is team id under which player has to create.

Below is the image of before sending POST request to create player.

![image](https://user-images.githubusercontent.com/46108315/159165688-d8d5a2aa-b3ed-40c1-b4a2-b103a63ea8e2.png)	

Below is the image of after sending POST request and getting response of created player 

![image](https://user-images.githubusercontent.com/46108315/159165702-72e3c1b0-a77f-4ec7-a292-05b65102248b.png)
 
The created player data has been saved in database as shown in below.

![image](https://user-images.githubusercontent.com/46108315/159165718-43bab728-936c-4d87-94c4-302600c3ee40.png)


Multiplt player has been saved in the player table which is mapped with team id.

![image](https://user-images.githubusercontent.com/46108315/159165733-3bfb1f3c-3909-497f-98b6-4c6712fd02e4.png)
 
# Find By Id
# Team
To find a Team by its id, I have sent GET request for the URL https://localhost:8080/api/team/40 and left body empty. In the URL, I have given RequestMapping as “/api/team/40” which is working for read endpoint where 40 is id of a team to be find.

Below is the image of before sending GET request to find a team.

![image](https://user-images.githubusercontent.com/46108315/159165761-da5ce5a6-1a86-4da5-b19f-b2e6f4d47bb8.png)
 
Below is the image of after sending GET request and getting response that a team has been found.

![image](https://user-images.githubusercontent.com/46108315/159165771-01d1dd4b-79fd-4555-a8d8-4902e0e87555.png)
 

# Player
To find a Player by its id, I have sent Get request for the URL https://localhost:8080/api/team/40/player/30 and left the body empty. In the URL, I have given RequestMapping as “/api/team/40/player/30” which is working for read endpoint where 40 is id of a team and 30 is id of a player to be find.

Below is the image of before sending GET request to find a player.

![image](https://user-images.githubusercontent.com/46108315/159165787-161baba4-536a-4832-8a65-aa1bc6077c2f.png)
 
Below is the image of after sending GET request and getting response that a team has been found.

![image](https://user-images.githubusercontent.com/46108315/159165796-0f4ceabd-18f2-4bc5-a9c3-6e00728ac328.png)
 

# Update
# Team

Before attempt to update the data, below is the image of team database.

![image](https://user-images.githubusercontent.com/46108315/159165824-cb3c98d2-b925-420d-8853-758465ebe8db.png)
 
To update team, I have sent PUT request for the URL https://localhost:8080/api/team/42. In the URL, I have given RequestMapping as “/api/team/42” which is working for update endpoint where 42 is id of a team to be updated.

Entered below data to send request body to the given URL endpoint. These are the Team data that will be updated into the database.

![image](https://user-images.githubusercontent.com/46108315/159165844-9b320c10-e487-403d-94ce-2952fc5cf089.png)
 
Below is the image of before sending PUT request to update a team.

![image](https://user-images.githubusercontent.com/46108315/159165866-7ef533b7-8ad9-4232-b3a9-625e1cac76dd.png)
 
Below is the image of after sending PUT request and getting response as updated team details.

![image](https://user-images.githubusercontent.com/46108315/159165883-de9789e6-1d34-4d6a-9520-5276d198cdc5.png)
 
Below is the image of updated team database where id is 42.

![image](https://user-images.githubusercontent.com/46108315/159165897-c6762cc8-871c-432e-8e40-4d588f09249b.png)
 
# Player

Before attempt to update the data, below is the image of player database.

![image](https://user-images.githubusercontent.com/46108315/159165910-2f088451-4dde-4dfd-a3c6-c0bec7d8f01d.png)
 
To find a Player by its id, I have sent PUT request for the URL https://localhost:8080/api/team/40/player/7. In the URL, I have given RequestMapping as “/api/team/40/player/7” which is working for update endpoint where 40 is id of a team and 7 is id of a player to be updated.

Entered below data to send request body to the given URL endpoint. These are the Player data that will be updated into the database.

![image](https://user-images.githubusercontent.com/46108315/159165924-aa5fcd1b-2c17-450b-bc0f-0d8ea30181c9.png)
 
Below is the image of before sending PUT request to update a player.

![image](https://user-images.githubusercontent.com/46108315/159165933-716b79ab-155c-4913-9b79-e84353460ff6.png)
 
Below is the image of after sending PUT request and getting response as updated player details.

![image](https://user-images.githubusercontent.com/46108315/159165944-127ade8c-1f7f-41bc-90f7-af242015a86c.png)
 
Below is the image of updated player database where player id is 7.

![image](https://user-images.githubusercontent.com/46108315/159165955-8ccca979-92ed-4815-b520-4ab4aa3feaff.png)
 
# Delete
# Team

Before attempt to delete the data, below is the image of team as well as player database. Player data will also be deleted if team data is deleted.

![image](https://user-images.githubusercontent.com/46108315/159165962-9cac6a2e-239d-42c9-aa53-ea39331d1c88.png) 

![image](https://user-images.githubusercontent.com/46108315/159165982-53cbafd2-5b01-45f3-9d72-73df3da57750.png)
 
To delete a team, I have sent DELETE request for the URL https://localhost:8080/api/team/41 and left the body empty. In the URL, I have given RequestMapping as “/api/team/41” which is working for delete endpoint where 41 is id of a team to be deleted.

Below is the image of before sending DELETE request to delete a team.

![image](https://user-images.githubusercontent.com/46108315/159165993-96bf1484-bb52-4fd2-9161-02e4eb622f45.png)
 
Below is the image of after sending DELETE request and getting HTTP status as 200 Ok.

![image](https://user-images.githubusercontent.com/46108315/159166004-0e4383ea-a403-4570-b2ad-9fd4eedac5b8.png) 

Here is the database of team and player where team id 41 has been deleted from team database and player data has also been deleted as team id is mapped with player database.

![image](https://user-images.githubusercontent.com/46108315/159166016-4dbb2eb7-b861-4c5e-97d4-1bfe1fe6cd96.png)

![image](https://user-images.githubusercontent.com/46108315/159166034-34f11b60-8ff5-44c7-bdb4-3d7563d7de74.png)
 
# Player

Before attempt to delete the data, below is the image of player database.

![image](https://user-images.githubusercontent.com/46108315/159166052-c4811422-228b-459b-b1ad-047d0a54adfd.png)
 
To delete a team, I have sent DELETE request for the URL https://localhost:8080/api/team/40/player/14 and left the body empty. In the URL, I have given RequestMapping as “/api/team/40/player/30” which is working for delete endpoint where 40 is id of a team and 14 is id of a player to be delete.

Below is the image of before sending DELETE request to delete a player.

![image](https://user-images.githubusercontent.com/46108315/159166063-74d7bf58-01bb-4dfd-a62e-d4ac702f9c7f.png)
 
Below is the image of after sending DELETE request and getting HTTP status as 200 Ok.

![image](https://user-images.githubusercontent.com/46108315/159166075-259b4ac0-368c-4465-abac-be776709119e.png)
 
Here is the database of player where player id 14 has been deleted from player database.

![image](https://user-images.githubusercontent.com/46108315/159166106-7d362afb-2927-43c4-8e5f-1009255d687d.png)
 
# Find players by team id

To find a Player by team id, I have sent GET request for the URL https://localhost:8080/api/team/40/player and left body empty. In the URL, I have given RequestMapping as “/api/team/40/player” which is working for read endpoint where 40 is id of a team using to find player.

Below is the image of before sending GET request to find a player.

![image](https://user-images.githubusercontent.com/46108315/159166126-4aed46fd-5665-4c78-bb62-1006c2547ef9.png)
 
Below is the image of after sending GET request and getting response that a player has been found.

![image](https://user-images.githubusercontent.com/46108315/159166136-b87c3478-4613-44ab-93a7-b3994192a324.png)
 
# Find team by player id

To find a Team by player id, I have sent GET request for the URL https://localhost:8080/api/10 and left body empty. In the URL, I have given RequestMapping as “/api/team/10” which is working for read endpoint where 10 is id of a player using to find team.

Below is the image of before sending GET request to find a team.

![image](https://user-images.githubusercontent.com/46108315/159166151-6c427a42-8913-4381-8b76-49f7b0829181.png)
 
Below is the image of after sending GET request and getting response that a team has been found.

![image](https://user-images.githubusercontent.com/46108315/159166159-722929aa-4cdc-486f-88a9-8737d2399a26.png)
 
