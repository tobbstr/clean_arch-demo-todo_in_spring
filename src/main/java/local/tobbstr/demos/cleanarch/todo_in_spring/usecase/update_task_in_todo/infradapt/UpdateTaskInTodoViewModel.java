package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infradapt;

public class UpdateTaskInTodoViewModel {
	private String error;

	public UpdateTaskInTodoViewModel(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

}
