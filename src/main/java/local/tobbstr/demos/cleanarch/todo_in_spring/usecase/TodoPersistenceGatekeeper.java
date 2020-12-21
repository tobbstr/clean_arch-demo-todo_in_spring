package local.tobbstr.demos.cleanarch.todo_in_spring.usecase;

import java.util.List;
import java.util.UUID;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;

/**
 * TodoPersistenceGatekeeper is a Clean Architecture Gateway defining the persistence
 * actions available for manipulating Todo and Task entity objects.
 * @author tobias
 *
 */
public interface TodoPersistenceGatekeeper {
	// Todo related methods
	Todo findTodoById(UUID todoId);
	Todo findTodoByTaskId(UUID taskId);
	List<Todo> getTodos();
	void saveTodo(Todo todo);
	void updateTodo(Todo todo);
	void removeTodo(Todo todo);
	
	// Task related methods
	Task findTaskById(UUID taskId);
	List<Task> findTasksByTodoId(UUID todoId);
	void saveTaskAndUpdateTodo(Task task, Todo todo);
	void updateTaskAndUpdateTodo(Task task);
	void removeTaskAndUpdateTodo(Task task, Todo todo);

}
