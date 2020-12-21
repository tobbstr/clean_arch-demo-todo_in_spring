package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoViewModel}
 * @author tobias
 *
 */
public class BrowseTasksInTodoViewModel {
	private List<Task> tasks;
	private String error;
	
	public BrowseTasksInTodoViewModel() {
		this.tasks = new ArrayList<BrowseTasksInTodoViewModel.Task>();
	}

	public List<Task> getTasks() {
		return tasks;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	void addTask(String id, String title, String description, String created, String modified) {
		var todo = new BrowseTasksInTodoViewModel.Task(id, title, description, created, modified);
		this.tasks.add(todo);
	}
	
	private static final class Task {
		private String id;
		private String title;
		private String description;
		private String created;
		private String modified;

		private Task(String id, String title, String description, String created, String modified) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.created = created;
			this.modified = modified;
		}

		public String getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public String getCreated() {
			return created;
		}
	
		public String getModified() {
			return modified;
		}
	}

}
