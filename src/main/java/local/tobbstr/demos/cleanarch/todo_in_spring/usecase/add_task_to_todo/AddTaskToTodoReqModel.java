package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo;

import java.util.UUID;

/**
 * AddTaskToTodoReqModel is a Clean Architecture Request Model. It's a POJO class
 * to pass data to the use case input boundary interface i.e. the Interactor.
 * @author tobias
 *
 */
public class AddTaskToTodoReqModel {
	private UUID todoId;
	private String title;
	private String description;
	
	public AddTaskToTodoReqModel(UUID todoId, String title, String description) {
		this.todoId = todoId;
		this.title = title;
		this.description = description;
	}
	
	public UUID getTodoId() {
		return todoId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}
}
