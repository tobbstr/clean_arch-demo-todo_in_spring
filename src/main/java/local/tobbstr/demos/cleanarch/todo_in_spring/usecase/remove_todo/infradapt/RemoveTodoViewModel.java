package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infradapt;

public class RemoveTodoViewModel {
	private String error;
	
	public RemoveTodoViewModel(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

}
