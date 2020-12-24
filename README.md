# Clean Architecture Demo - Todo app in Spring Boot
## Background
This demo demonstrates one of many possible ways to organise source code according to Clean Architecture, more specifically, in the form of a Todo app.
After writing the article [Clean Architecture Demystified](https://adevelopersdiscourse.blogspot.com/2020/06/clean-architecture-demystified.html), I wanted to get a little hands-on and go from theory to practice. As always there are things to discover when implementing something for real. If you're not familiar with Clean Architecture, I suggest you read my article before reading the source code in this repo. I've also written another article [Implementing Clean Architecture](https://adevelopersdiscourse.blogspot.com/2020/12/implementing-clean-architecture.html) that complements this repo, giving context to it. I highly recommend you to read that one as well.
## Original Setup
* Spring Boot v2.3.5.RELEASE
* Java v11
* H2 Database
* Maven on MacOS
## REST API
The Todo app server provides the following actions:
#### Browse Todos
Endpoint is GET http://localhost:8080/todos
#### Create Todo
Endpoint is POST http://localhost:8080/todos <br/>
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Errands"
}
```
#### Remove Todo
Endpoint is DELETE http://localhost:8080/todos/{todoId} <br/>
Where {todoId} is a UUID
#### Update Todo
Endpoint is PUT http://localhost:8080/todos/{todoId} <br/>
Where {todoId} is a UUID <br/>
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Personal errands",
}
```
#### Browse Task in Todo
Endpoint is GET http://localhost:8080/todos/{todoId}/tasks <br/>
Where {todoId} is a UUID
#### Create Task in Todo
Endpoint is POST http://localhost:8080/todos/{todoId}/tasks <br/>
Where {todoId} is a UUID <br/>
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Read book on Spring Boot",
	"description": "My colleague at work suggested that I read a book on Spring Boot"
}
```
#### Remove Task in Todo
Endpoint is DELETE http://localhost:8080/todos/{todoId}/tasks/{taskId} <br/>
Where {todoId} and {taskId} are UUIDs
#### Update Task in Todo
Endpoint is PUT http://localhost:8080/todos/{todoId}/tasks/{taskId} <br/>
Where {todoId} and {taskId} are UUIDs <br/>
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Read book on Clean Architecture",
	"description": "My colleague at work suggested that I read a book on Clean Architecture"
}
```
