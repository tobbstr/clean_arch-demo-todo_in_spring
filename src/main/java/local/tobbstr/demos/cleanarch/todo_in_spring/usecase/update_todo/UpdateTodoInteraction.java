package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class UpdateTodoInteraction implements UpdateTodoInteractor {
	private UpdateTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public UpdateTodoInteraction(UpdateTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * updateTodo updates a Todo entity
	 * @param reqModel is a clean architecture request model
	 * @return UpdateTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void updateTodo(UpdateTodoReqModel reqModel) {
		// Gets Todo from persistence store
		Todo todo = null;
		try {
			todo = gatekeeper.findTodoById(reqModel.getTodoId());
		} catch (Exception e) {
			presenter.updateTodo(new UpdateTodoResModel("could not find Todo in persistence store"));
			throw new RuntimeException(
					String.format("could not find Todo with Id[%s]: %s",
							reqModel.getTodoId(), e.getMessage()), e);
		}

		// Modifies Todo's title
		todo.setTitle(reqModel.getTitle());
		
		// Persists modified Todo
		try {
			gatekeeper.updateTodo(todo);
		} catch (Exception e) {
			presenter.updateTodo(new UpdateTodoResModel("could not update Todo"));
			throw new RuntimeException(
					String.format("could not update Todo with Id[%s]: %s",
							todo.getId(), e.getMessage()), e);
		}

		presenter.updateTodo(new UpdateTodoResModel(null));
	}
}
