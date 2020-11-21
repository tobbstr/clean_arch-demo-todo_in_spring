package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infradapt;

public class AddTaskToTodoViewModel {
	private String taskId;
	private String error;

	public AddTaskToTodoViewModel(String taskId, String error) {
		this.taskId = taskId;
		this.error = error;
	}

	public String getTaskId() {
		return taskId;
	}
	public String getError() {
		return error;
	}

}
