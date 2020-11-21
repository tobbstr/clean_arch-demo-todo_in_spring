package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo;

public class UpdateTaskInTodoResModel {
	private String errMsg;

	public UpdateTaskInTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}
}
