package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class RemoveTodoInteraction implements RemoveTodoInteractor {
	private RemoveTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public RemoveTodoInteraction(RemoveTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * removeTodo removes a Todo entity
	 * @param reqModel is a clean architecture request model
	 * @return RemoveTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void removeTodo(RemoveTodoReqModel reqModel) {
		Todo todo = null;
		try {
			todo = gatekeeper.findTodoById(reqModel.getTodoId());
		} catch (Exception e) {
			presenter.removeTodo(new RemoveTodoResModel("could not find Todo in persistence store"));
			throw new RuntimeException(
					String.format("could not find Todo with Id[%s]: %s",
							reqModel.getTodoId(), e.getMessage()), e);
		}
		try {
			gatekeeper.removeTodo(todo);
		} catch (Exception e) {
			presenter.removeTodo(new RemoveTodoResModel("could not remove Todo from persistence store"));
			throw new RuntimeException(
					String.format("could not remove Todo with Id[%s]: %s",
							todo.getId(), e.getMessage()), e);
		}
		presenter.removeTodo(new RemoveTodoResModel(null));
	}

}
