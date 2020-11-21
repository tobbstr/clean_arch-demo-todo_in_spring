package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

import java.util.UUID;

public class UpdateTodoReqModel {
	private UUID todoId;
	private String title;
	
	public UpdateTodoReqModel(UUID todoId, String title) {
		this.todoId = todoId;
		this.title = title;
	}

	public UUID getTodoId() {
		return todoId;
	}

	public String getTitle() {
		return title;
	}
}
