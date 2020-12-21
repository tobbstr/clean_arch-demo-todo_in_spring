package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * This class has identical responsibilities to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel}
 * @author tobias
 *
 */
public class BrowseTasksInTodoResModel {
	private final List<BrowseTasksInTodoResModel.Task> tasks;
	private String errMsg;
	
	public BrowseTasksInTodoResModel(List<BrowseTasksInTodoResModel.Task> tasks, String errMsg) {
		this.tasks = tasks;
		this.errMsg = errMsg;
	}
	
	public List<BrowseTasksInTodoResModel.Task> getTasks() {
		return tasks;
	}
	
	public String getErrMsg() {
		return errMsg;
	}

	public static final class Task {
		private UUID id;
		private String title;
		private String description;
		private Instant created;
		private Instant modified;
		
		Task(UUID id, String title, String description, Instant created, Instant modified) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.created = created;
			this.modified = modified;
		}
		
		public UUID getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}
		
		public Instant getCreated() {
			return created;
		}
		
		public Instant getModified() {
			return modified;
		}
	}
}
