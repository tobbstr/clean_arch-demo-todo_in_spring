package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

public class RemoveTaskFromTodoResModel {
	private String errMsg;

	public RemoveTaskFromTodoResModel(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

}
