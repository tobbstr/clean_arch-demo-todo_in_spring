package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infradapt;

public class CreateTodoViewModel {
	private String todoId;
	private String error;

	public CreateTodoViewModel(String todoId, String errmsg) {
		this.todoId = todoId;
		if (errmsg == null) {
			this.error = "";
		} else {
			this.error = errmsg;
		}
	}

	public String getTodoId() {
		return todoId;
	}
	public String getError() {
		return error;
	}

}
