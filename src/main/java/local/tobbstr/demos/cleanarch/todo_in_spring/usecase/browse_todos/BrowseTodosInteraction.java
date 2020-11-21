package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

public class BrowseTodosInteraction implements BrowseTodosInteractor {
	private BrowseTodosPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public BrowseTodosInteraction(BrowseTodosPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * browseTodos browses Todo entities
	 * @return BrowseTodosResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void browseTodos() {
		var resModel = new BrowseTodosResModel();
		// Gets Todos from persistence store and presents the Response Model
		try {
			var todos = gatekeeper.getTodos();
			todos.forEach(todo -> {
				resModel.addTodo(todo.getId(), todo.getTitle(), todo.getNoTasks(), todo.getCreated(), todo.getModified());
			});
			presenter.browseTodos(resModel);
		} catch (Exception e) {
			resModel.setErrMsg("could not get Todos");
			presenter.browseTodos(resModel);
			throw new RuntimeException(
					String.format("could not get Todos: %s", e.getMessage()), e);
		}
	}

}
