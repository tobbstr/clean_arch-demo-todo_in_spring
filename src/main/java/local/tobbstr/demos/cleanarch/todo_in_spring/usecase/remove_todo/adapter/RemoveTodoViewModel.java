package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoViewModel}
 * @author tobias
 *
 */
public class RemoveTodoViewModel {
	private String error;
	
	public RemoveTodoViewModel(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

}
