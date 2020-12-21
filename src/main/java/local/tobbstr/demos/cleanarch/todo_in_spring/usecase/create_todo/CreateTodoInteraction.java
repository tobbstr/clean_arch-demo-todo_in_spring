package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo;

import java.util.UUID;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Todo;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

/**
 * CreateTodoInteraction is an implementation of {@link CreateTodoInteractor}.
 * @author tobias
 *
 */
public class CreateTodoInteraction implements CreateTodoInteractor {
	private CreateTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public CreateTodoInteraction(CreateTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * createTodo creates a Todo entity
	 * @param reqModel is a clean architecture request model
	 * @return CreateTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void createTodo(CreateTodoReqModel reqModel) {
		// Business rule: Allow for a maximum of 5 Todos in free version
		try {
			if (gatekeeper.getTodos().size() >= 5) {
				presenter.createTodo(new CreateTodoResModel(null, "Todo limit of 5 reached"));
				return;
			}
		} catch (Exception e) {
			presenter.createTodo(new CreateTodoResModel(null, "could not get Todos from persistence store"));
			throw new RuntimeException(
					String.format("could not get Todos from gatekeeper: %s", e.getMessage()), e);
		}
		
		var todoId = UUID.randomUUID();

		// Constructs Todo
		Todo todo;
		try {
			todo = new Todo(todoId, reqModel.getTitle(), 0, null, null);
		} catch (Exception e) {
			presenter.createTodo(new CreateTodoResModel(null, "could not construct Todo"));
			throw new RuntimeException(
					String.format("could not construct Todo: %s", e.getMessage()), e);
		}

		// Persists Todo
		try {
			gatekeeper.saveTodo(todo);
		} catch (Exception e) {
			presenter.createTodo(new CreateTodoResModel(null, "could not persist Todo"));
			throw new RuntimeException(
					String.format("could not persist Todo with Id[%s]: %s",
							todo.getId(), e.getMessage()), e);
		}

		presenter.createTodo(new CreateTodoResModel(todoId, null));
	}




	

	




}
