package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class UpdateTaskInTodoInteraction implements UpdateTaskInTodoInteractor {
	private UpdateTaskInTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public UpdateTaskInTodoInteraction(UpdateTaskInTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * updateTaskInTodo updates Task entity in Todo
	 * @param reqModel is a clean architecture request model
	 * @return UpdateTaskInTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void updateTaskInTodo(UpdateTaskInTodoReqModel reqModel) {
		// Finds Task in persistence store
		Task task = null;
		try {
			task = gatekeeper.findTaskById(reqModel.getTaskId());
		} catch (Exception e) {
			presenter.updateTaskInTodo(new UpdateTaskInTodoResModel("could not find Task"));
			throw new RuntimeException(
					String.format("could not find Task with Id[%s]: %s",
							reqModel.getTaskId(), e.getMessage()), e);
		}
		
		// Updates Task model
		task.setTitle(reqModel.getTitle());
		task.setDescription(reqModel.getDescription());
		
		// Finds Todo in persistence store
		Todo todo = null;
		try {
			todo = gatekeeper.findTodoByTaskId(reqModel.getTaskId());
		} catch (Exception e) {
			presenter.updateTaskInTodo(new UpdateTaskInTodoResModel("could not find Todo"));
			throw new RuntimeException(
					String.format("could not find Todo for Task with Id[%s]: %s",
							reqModel.getTaskId(), e.getMessage()), e);
		}
		
		// Performs business logic
		todo.updateTask(task);
		
		// Updates Task in persistence store
		try {
			gatekeeper.updateTaskAndUpdateTodo(task);
		} catch (Exception e) {
			presenter.updateTaskInTodo(new UpdateTaskInTodoResModel("could not update Task"));
			throw new RuntimeException(
					String.format("could not update Task with Id[%s] and Todo with Id[%s]: %s",
							task.getId(), todo.getId(), e.getMessage()), e);
		}

		presenter.updateTaskInTodo(new UpdateTaskInTodoResModel(null));
	}

}
