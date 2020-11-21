package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrowseTodosResModel {
	private List<Todo> todos;
	private String errMsg;
	
	public BrowseTodosResModel() {
		this.todos = new ArrayList<BrowseTodosResModel.Todo>();
	}

	public List<Todo> getTodos() {
		return todos;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	void addTodo(UUID id, String title, int noTasks, Instant created, Instant modified) {
		var todo = new BrowseTodosResModel.Todo(id, title, noTasks, created, modified);
		this.todos.add(todo);
	}
	
	public static final class Todo {
		private UUID id;
		private String title;
		private int noTasks;
		private Instant created;
		private Instant modified;

		private Todo(UUID id, String title, int noTasks, Instant created, Instant modified) {
			this.id = id;
			this.title = title;
			this.noTasks = noTasks;
			this.created = created;
			this.modified = modified;
		}
		
		public UUID getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public int getNoTasks() {
			return noTasks;
		}

		public Instant getCreated() {
			return created;
		}
	
		public Instant getModified() {
			return modified;
		}
	}
}
