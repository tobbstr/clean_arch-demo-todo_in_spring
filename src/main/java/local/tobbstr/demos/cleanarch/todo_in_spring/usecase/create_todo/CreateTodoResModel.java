package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo;

import java.util.UUID;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel}
 * @author tobias
 *
 */
public class CreateTodoResModel {
	private UUID todoId;
	private String errMsg;

	CreateTodoResModel(UUID todoId, String errMsg) {
		this.todoId = todoId;
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	
	public UUID getTodoId() {
		return todoId;
	}
}
