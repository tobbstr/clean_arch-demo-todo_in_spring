package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoPresenter;

/**
 * RemoveTodoInteractorFactory is an implementation of {@link RemoveTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class RemoveTodoInteractorFactory implements RemoveTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public RemoveTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public RemoveTodoInteractor makeInteractorFrom(RemoveTodoPresenter presenter) {
		return new RemoveTodoInteraction(presenter, gatekeeper);
	}

}
