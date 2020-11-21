package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infradapt;

import java.util.UUID;

public class AddTaskToTodoMvcModel {
	private UUID todoId;
	private String title;
	private String description;
	
	public AddTaskToTodoMvcModel() {}

	public AddTaskToTodoMvcModel(UUID todoId, String title, String description) {
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
