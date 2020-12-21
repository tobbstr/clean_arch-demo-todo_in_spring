package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel}
 * @author tobias
 *
 */
public class RemoveTaskFromTodoResModel {
	private String errMsg;

	public RemoveTaskFromTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

}
