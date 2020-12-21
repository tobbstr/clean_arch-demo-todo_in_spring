package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel}
 * @author tobias
 *
 */
public class CreateTodoReqModel {
	private String title;
	
	public CreateTodoReqModel(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
