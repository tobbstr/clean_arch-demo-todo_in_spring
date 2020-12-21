package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoViewModel}
 * @author tobias
 *
 */
public class CreateTodoViewModel {
	private String todoId;
	private String error;

	public CreateTodoViewModel(String todoId, String errmsg) {
		this.todoId = todoId;
		if (errmsg == null) {
			this.error = "";
		} else {
			this.error = errmsg;
		}
	}

	public String getTodoId() {
		return todoId;
	}
	public String getError() {
		return error;
	}

}
