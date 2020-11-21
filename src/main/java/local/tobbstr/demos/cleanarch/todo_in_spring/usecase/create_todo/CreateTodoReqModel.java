package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo;

public class CreateTodoReqModel {
	private String title;
	
	public CreateTodoReqModel(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
