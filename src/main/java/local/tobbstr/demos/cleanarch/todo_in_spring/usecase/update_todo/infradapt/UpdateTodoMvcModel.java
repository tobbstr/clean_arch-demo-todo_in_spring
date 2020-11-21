package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt;

public class UpdateTodoMvcModel {
	private String title;
	
	public UpdateTodoMvcModel() {}
	
	public UpdateTodoMvcModel(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
