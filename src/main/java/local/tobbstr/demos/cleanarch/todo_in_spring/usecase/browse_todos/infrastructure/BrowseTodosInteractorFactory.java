package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosPresenter;

/**
 * BrowseTodosInteractorFactory is an implementation of {@link BrowseTodosInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class BrowseTodosInteractorFactory implements BrowseTodosInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public BrowseTodosInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public BrowseTodosInteractor makeInteractorFrom(BrowseTodosPresenter presenter) {
		return new BrowseTodosInteraction(presenter, gatekeeper);
	}

}
