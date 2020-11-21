package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infradapt;

public class RemoveTaskFromTodoViewModel {
	private String error;
	
	public RemoveTaskFromTodoViewModel() {}

	public RemoveTaskFromTodoViewModel(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
