package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo;

import java.util.UUID;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel}
 * @author tobias
 *
 */
public class UpdateTaskInTodoReqModel {
	private UUID taskId;
	private String title;
	private String description;

	public UpdateTaskInTodoReqModel(UUID taskId, String title, String description) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
