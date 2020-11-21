package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt;

public class UpdateTodoViewModel {
	private String error;

	public UpdateTodoViewModel(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}
}
