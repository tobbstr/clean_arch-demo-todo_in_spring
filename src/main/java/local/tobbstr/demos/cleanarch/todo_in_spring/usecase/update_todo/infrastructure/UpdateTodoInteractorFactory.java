package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter.UpdateTodoPresenter;

/**
 * UpdateTodoInteractorFactory is an implementation of {@link UpdateTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class UpdateTodoInteractorFactory implements UpdateTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public UpdateTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public UpdateTodoInteractor makeInteractorFrom(UpdateTodoPresenter presenter) {
		return new UpdateTodoInteraction(presenter, gatekeeper);
	}
}
