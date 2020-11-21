package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class RemoveTaskFromTodoInteraction implements RemoveTaskFromTodoInteractor {
	private RemoveTaskFromTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public RemoveTaskFromTodoInteraction(RemoveTaskFromTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * removeTaskFromTodo removes Task entity in Todo
	 * @param reqModel is a clean architecture request model
	 * @return RemoveTaskFromTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void removeTaskFromTodo(RemoveTaskFromTodoReqModel reqModel) {
		// Finds Task in persistence store
		Task task = null;
		try {
			task = gatekeeper.findTaskById(reqModel.getTaskId());
		} catch (Exception e) {
			presenter.removeTaskFromTodo(new RemoveTaskFromTodoResModel("could not find Task"));
			throw new RuntimeException(
					String.format("could not find Task with Id[%s]: %s",
							reqModel.getTaskId(), e.getMessage()), e);
		}
		
		// Finds Todo in persistence store
		Todo todo = null;
		try {
			todo = gatekeeper.findTodoByTaskId(reqModel.getTaskId());
		} catch (Exception e) {
			presenter.removeTaskFromTodo(new RemoveTaskFromTodoResModel("could not find Todo"));
			throw new RuntimeException(
					String.format("could not find Todo for Task with Id[%s]: %s",
							reqModel.getTaskId(), e.getMessage()), e);
		}
		
		// Performs business logic
		todo.removeTask(task);
		
		// Removes Task from and updates Todo in persistence store
		try {
			gatekeeper.removeTaskAndUpdateTodo(task, todo);
		} catch (Exception e) {
			presenter.removeTaskFromTodo(new RemoveTaskFromTodoResModel("could not remove Task"));
			throw new RuntimeException(
					String.format("could not remove Task with Id[%s] and update Todo with Id[%s]: %s",
							reqModel.getTaskId(), todo.getId(), e.getMessage()), e);
		}
		presenter.removeTaskFromTodo(new RemoveTaskFromTodoResModel(null));
	}

}
