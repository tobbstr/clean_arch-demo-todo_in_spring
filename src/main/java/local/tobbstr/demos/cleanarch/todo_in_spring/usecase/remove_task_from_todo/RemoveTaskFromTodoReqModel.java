package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

import java.util.UUID;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel}
 * @author tobias
 *
 */
public class RemoveTaskFromTodoReqModel {
	private UUID taskId;

	public RemoveTaskFromTodoReqModel(UUID taskId) {
		this.taskId = taskId;
	}

	public UUID getTaskId() {
		return taskId;
	}
}
