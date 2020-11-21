package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo;

import java.util.UUID;

public class BrowseTasksInTodoReqModel {
	private UUID todoId;
	
	public BrowseTasksInTodoReqModel(UUID todoId) {
		this.todoId = todoId;
	}
	
	public UUID getTodoId() {
		return todoId;
	}
}
