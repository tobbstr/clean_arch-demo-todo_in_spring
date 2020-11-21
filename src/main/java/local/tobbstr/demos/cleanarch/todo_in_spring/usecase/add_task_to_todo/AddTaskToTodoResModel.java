package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo;

import java.util.UUID;

public class AddTaskToTodoResModel {
	private UUID taskId;
	private String errMsg;

	public AddTaskToTodoResModel(UUID taskId, String errMsg) {
		this.taskId = taskId;
		this.errMsg = errMsg;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public String getErrMsg() {
		return errMsg;
	}
}
