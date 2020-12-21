package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel}
 * @author tobias
 *
 */
public class UpdateTaskInTodoResModel {
	private String errMsg;

	public UpdateTaskInTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}
}
