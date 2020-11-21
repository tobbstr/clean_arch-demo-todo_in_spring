package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo;

import java.util.UUID;

public class RemoveTodoReqModel {
	private UUID todoId;
	
	public RemoveTodoReqModel(UUID todoId) {
		this.todoId = todoId;
	}
	
	public UUID getTodoId() {
		return todoId;
	}
}
