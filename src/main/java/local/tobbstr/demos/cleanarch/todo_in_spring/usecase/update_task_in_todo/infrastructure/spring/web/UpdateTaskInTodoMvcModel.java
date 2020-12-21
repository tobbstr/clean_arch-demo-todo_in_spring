package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure.spring.web;

public class UpdateTaskInTodoMvcModel {
	private String title;
	private String description;
	
	public UpdateTaskInTodoMvcModel() {}

	public UpdateTaskInTodoMvcModel(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

}
