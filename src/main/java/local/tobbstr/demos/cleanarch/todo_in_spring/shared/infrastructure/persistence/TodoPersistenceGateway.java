package local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence.spring.data_jpa.TaskHibernateEntity;
import local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence.spring.data_jpa.TaskJpaRepository;
import local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence.spring.data_jpa.TodoHibernateEntity;
import local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence.spring.data_jpa.TodoJpaRepository;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

/**
 * TodoPersistenceGateway is a Java Persistence API (JPA) implementation of
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper}.
 * @author tobias
 *
 */
@Repository
@Transactional
public class TodoPersistenceGateway implements TodoPersistenceGatekeeper {
	private TodoJpaRepository todoJpaRepository;
	private TaskJpaRepository taskJpaRepository;
	
	public TodoPersistenceGateway(TodoJpaRepository todoJpaRepository, TaskJpaRepository taskJpaRepository) {
		this.todoJpaRepository = todoJpaRepository;
		this.taskJpaRepository = taskJpaRepository;
	}

	@Override
	public Todo findTodoById(UUID todoId) {
		var todoJpaOptional = todoJpaRepository.findById(todoId);
		if (!todoJpaOptional.isPresent()) {
			return null;
		}
		var todoJpa = todoJpaOptional.get();
		return new Todo(
				todoJpa.getTodoId(), todoJpa.getTitle(), todoJpa.getTaskHibernateEntities().size(),
				todoJpa.getCreated(), todoJpa.getModified());
	}

	@Override
	public Todo findTodoByTaskId(UUID taskId) {
		var taskJpaOptional = taskJpaRepository.findById(taskId);
		if (!taskJpaOptional.isPresent()) {
			return null;
		}
		var todoJpa = taskJpaOptional.get().getTodoHibernateEntity();
		return new Todo(
				todoJpa.getTodoId(), todoJpa.getTitle(), todoJpa.getTaskHibernateEntities().size(),
				todoJpa.getCreated(), todoJpa.getModified());
	}

	@Override
	public List<Todo> getTodos() {
		var todosJpa = todoJpaRepository.findAll();
		var todos = new ArrayList<Todo>();
		for (TodoHibernateEntity todoJpa : todosJpa) {
			var todo = new Todo(
					todoJpa.getTodoId(), todoJpa.getTitle(), todoJpa.getTaskHibernateEntities().size(),
					todoJpa.getCreated(), todoJpa.getModified());
			todos.add(todo);
		}
		return todos;
	}

	@Override
	public void saveTodo(Todo todo) {
		var todoJpa = new TodoHibernateEntity(
				todo.getId(), todo.getTitle(), todo.getCreated());
		todoJpaRepository.save(todoJpa);
	}
	
	@Override
	public void updateTodo(Todo todo) {
		var todoJpaOptional = todoJpaRepository.findById(todo.getId());
		if (!todoJpaOptional.isPresent()) {
			return;
		}
		var todoJpa = todoJpaOptional.get();
		todoJpa.setTitle(todo.getTitle());
		todoJpaRepository.save(todoJpa);
	}

	@Override
	public void removeTodo(Todo todo) {
		var todoJpa = new TodoHibernateEntity(
				todo.getId(), null, null);
		todoJpaRepository.delete(todoJpa);
	}

	@Override
	public Task findTaskById(UUID taskId) {
		var taskJpaOptional = taskJpaRepository.findById(taskId);
		if (!taskJpaOptional.isPresent()) {
			return null;
		}
		var taskJpa = taskJpaOptional.get();
		return new Task(taskJpa.getTaskId(), taskJpa.getTitle(), taskJpa.getDescription());
	}

	@Override
	public List<Task> findTasksByTodoId(UUID todoId) {
		var todoJpaOptional = todoJpaRepository.findById(todoId);
		if (!todoJpaOptional.isPresent()) {
			return Collections.emptyList();
		}
		var tasksJpa = todoJpaOptional.get().getTaskHibernateEntities();
		List<Task> tasks = new ArrayList<>();
		for (TaskHibernateEntity taskJpa : tasksJpa) {
			var task = new Task(
					taskJpa.getTaskId(), taskJpa.getTitle(), taskJpa.getDescription(),
					taskJpa.getCreated(), taskJpa.getModified());
			tasks.add(task);
		}
		return tasks;
	}

	@Override
	public void saveTaskAndUpdateTodo(Task task, Todo todo) {
		var todoJpaOptional = todoJpaRepository.findById(todo.getId());
		if (!todoJpaOptional.isPresent()) {
			return;
		}
		var todoJpa = todoJpaOptional.get();
		var taskJpa = new TaskHibernateEntity(
			task.getId(), task.getTitle(), task.getDescription(), task.getCreated(), todoJpa);
		todoJpa.addTaskHibernateEntity(taskJpa);
		todoJpaRepository.save(todoJpa);
	}
	
	@Override
	public void updateTaskAndUpdateTodo(Task task) {
		var taskJpaOptional = taskJpaRepository.findById(task.getId());
		if (!taskJpaOptional.isPresent()) {
			return;
		}
		var taskJpa = taskJpaOptional.get();
		taskJpa.setTaskId(task.getId());
		taskJpa.setTitle(task.getTitle());
		taskJpa.setDescription(task.getDescription());
		var todoJpa = taskJpa.getTodoHibernateEntity();
		todoJpa.setModifiedNow();
		todoJpaRepository.save(todoJpa);
	}


	@Override
	public void removeTaskAndUpdateTodo(Task task, Todo todo) {
		var todoJpa = new TodoHibernateEntity(todo.getId(), todo.getTitle(), todo.getCreated());
		var taskJpa = new TaskHibernateEntity(
				task.getId(), task.getTitle(), task.getDescription(), task.getCreated(), todoJpa);
		todoJpa.setModifiedNow();
		taskJpaRepository.delete(taskJpa);
		todoJpaRepository.save(todoJpa);
	}

}
