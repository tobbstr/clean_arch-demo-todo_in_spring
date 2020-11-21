package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infradapt;

import java.util.ArrayList;
import java.util.List;

public class BrowseTodosViewModel {
	private List<Todo> todos;
	private String error;
	
	public BrowseTodosViewModel() {
		this.todos = new ArrayList<BrowseTodosViewModel.Todo>();
	}

	public List<Todo> getTodos() {
		return todos;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	void addTodo(String id, String title, int noTasks, String created, String modified) {
		var todo = new BrowseTodosViewModel.Todo(id, title, noTasks, created, modified);
		this.todos.add(todo);
	}
	
	private static final class Todo {
		private String id;
		private String title;
		private int noTasks;
		private String created;
		private String modified;

		private Todo(String id, String title, int noTasks, String created, String modified) {
			this.id = id;
			this.title = title;
			this.noTasks = noTasks;
			this.created = created;
			this.modified = modified;
		}
		
		public String getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public int getNoTasks() {
			return noTasks;
		}

		public String getCreated() {
			return created;
		}
	
		public String getModified() {
			return modified;
		}
	}

}
