package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel}
 * @author tobias
 *
 */
public class UpdateTodoResModel {
	public String errMsg;
	
	public UpdateTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

}
