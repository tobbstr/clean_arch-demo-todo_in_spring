package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo;

import java.util.UUID;

import javax.naming.SizeLimitExceededException;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class AddTaskToTodoInteraction implements AddTaskToTodoInteractor {
	private AddTaskToTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public AddTaskToTodoInteraction(AddTaskToTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * addTaskToTodo adds Task entity to Todo
	 * @param reqModel is a clean architecture request model
	 * @return AddTaskToTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void addTaskToTodo(AddTaskToTodoReqModel reqModel) {
		// Finds Todo in persistence store
		Todo todo = null;
		try {
			todo = gatekeeper.findTodoById(reqModel.getTodoId());
		} catch (Exception e) {
			// Either no Todo is found or an error occurred while getting the Todo from the
			// persistence store
			presenter.addTaskToTodo(new AddTaskToTodoResModel(null, "could not find Todo"));
			// throws a RuntimeException for logging purposes in the framework controller
			throw new RuntimeException(
					String.format("could not find Todo with Id[%s]: %s", reqModel.getTodoId(), e.getMessage()), e);
		}

		// Declares and instantiates a new Task
		var task = new Task(UUID.randomUUID(), reqModel.getTitle(), reqModel.getDescription());

		// Performs business logic
		try {
			todo.addTask(task);
		} catch (SizeLimitExceededException sizeLimitExceededException) {
			presenter.addTaskToTodo(new AddTaskToTodoResModel(null, "could not add Task due to limit of 3 reached"));
			// after the Presenter has prepared a ViewModel this method returns since its work is done
			return;
		}

		// Persists the new Task and modified Todo
		try {
			gatekeeper.saveTaskAndUpdateTodo(task, todo);
		} catch (Exception e) {
			presenter.addTaskToTodo(new AddTaskToTodoResModel(null, "could not persist modified Task"));
			// throws a RuntimeException for logging purposes in the framework controller
			throw new RuntimeException(
					String.format("could not persist modified Task with Id[%s] and Todo with Id[%s]: %s",
							task.getId(), todo.getId(), e.getMessage()), e);
		}
		presenter.addTaskToTodo(new AddTaskToTodoResModel(task.getId(), null));
	}
}
