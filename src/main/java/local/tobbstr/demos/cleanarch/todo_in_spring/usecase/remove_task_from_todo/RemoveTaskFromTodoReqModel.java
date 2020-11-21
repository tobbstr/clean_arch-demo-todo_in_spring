package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

import java.util.UUID;

public class RemoveTaskFromTodoReqModel {
	private UUID taskId;

	public RemoveTaskFromTodoReqModel(UUID taskId) {
		this.taskId = taskId;
	}

	public UUID getTaskId() {
		return taskId;
	}
}
