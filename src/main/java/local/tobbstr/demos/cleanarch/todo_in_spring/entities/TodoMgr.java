package local.tobbstr.demos.cleanarch.todo_in_spring.entities;

import java.util.List;

public class TodoMgr {
	private List<Todo> todos;
	
	public TodoMgr(List<Todo> todos) {
		this.todos = todos;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}
	
	public void addTodo(Todo todo) {
		this.todos.add(todo);
	}
	
	public void removeTodo(Todo todo) {
		this.todos.remove(todo);
	}
}
