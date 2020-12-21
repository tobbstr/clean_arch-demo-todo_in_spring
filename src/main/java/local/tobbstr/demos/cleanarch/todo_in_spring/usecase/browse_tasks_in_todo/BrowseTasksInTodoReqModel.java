package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo;

import java.util.UUID;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel}
 * @author tobias
 *
 */
public class BrowseTasksInTodoReqModel {
	private UUID todoId;
	
	public BrowseTasksInTodoReqModel(UUID todoId) {
		this.todoId = todoId;
	}
	
	public UUID getTodoId() {
		return todoId;
	}
}
