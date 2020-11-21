package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infradapt;

import javax.validation.constraints.NotBlank;

public class CreateTodoMvcModel {
	@NotBlank
	private String title;
	
	public CreateTodoMvcModel() {}

	public CreateTodoMvcModel(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
