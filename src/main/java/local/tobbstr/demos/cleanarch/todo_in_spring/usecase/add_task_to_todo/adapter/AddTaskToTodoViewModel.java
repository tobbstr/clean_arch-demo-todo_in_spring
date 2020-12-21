package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter;

/**
 * AddTaskToTodoViewModel is a Clean Architecture ViewModel, which is a POJO with
 * with all the necessary data to render a response to a user.
 * For example, when rendering dynamic HTML the ViewModel is what the View engine
 * combines with a HTML template to render the final HTML. The ViewModel might include 
 * boolean flags to indicate whether validation has failed for particular fields or
 * flags for whether to show something to a user.
 * @author tobias
 *
 */
public class AddTaskToTodoViewModel {
	private String taskId;
	private String error;

	public AddTaskToTodoViewModel(String taskId, String error) {
		this.taskId = taskId;
		this.error = error;
	}

	public String getTaskId() {
		return taskId;
	}
	public String getError() {
		return error;
	}

}
