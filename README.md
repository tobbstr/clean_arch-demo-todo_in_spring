# Clean Architecture Demo - Todo app in Spring Boot
## Background
This demo demonstrates one out of many possible ways to organise source code according to Clean Architecture, more specifically, in the form of a Todo app.
The source code has been segmented into the following three Java packages at the root level of the application:
* **Entities**: Pure business rules and objects
* **Infrastructure**: Pure delivery mechanisms
* **Use case**: Application specific business rules and objects. Each use case has been given its own Java package. One thing to note is that code belonging to the Frameworks & Drivers and Interfaces and Adapters layers, has been put into a joint sub-package in each use case package called Infradapt to convey its intent and purpose. The reason was to keep code belonging to a use case together. Also because I believe it to be the optimal structure for most apps implementing Clean Architecture. Another option would be to keep them as separate layers which would require more interfaces and Data Transfer Objects to implement. This would result in classes with narrower responsibilities, which would be good for testability among other things, but at the same time this would increase implementation complexity.
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
Endpoint is POST http://localhost:8080/todos\
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Errands"
}
```
#### Remove Todo
Endpoint is DELETE http://localhost:8080/todos/{todoId}\
Where {todoId} is a UUID
#### Update Todo
Endpoint is PUT http://localhost:8080/todos/{todoId}\
Where {todoId} is a UUID\
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Personal errands",
}
```
#### Browse Task in Todo
Endpoint is GET http://localhost:8080/todos/{todoId}/tasks\
Where {todoId} is a UUID
#### Create Task in Todo
Endpoint is POST http://localhost:8080/todos/{todoId}/tasks\
Where {todoId} is a UUID\
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Read book on Spring Boot",
	"description": "My colleague at work suggested that I read a book on Spring Boot"
}
```
#### Remove Task in Todo
Endpoint is DELETE http://localhost:8080/todos/{todoId}/tasks/{taskId}\
Where {todoId} and {taskId} are UUIDs
#### Update Task in Todo
Endpoint is PUT http://localhost:8080/todos/{todoId}/tasks/{taskId}\
Where {todoId} and {taskId} are UUIDs\
Example HTTP Request Body (raw JSON):
```json
{
	"title": "Read book on Clean Architecture",
	"description": "My colleague at work suggested that I read a book on Clean Architecture"
}
```
