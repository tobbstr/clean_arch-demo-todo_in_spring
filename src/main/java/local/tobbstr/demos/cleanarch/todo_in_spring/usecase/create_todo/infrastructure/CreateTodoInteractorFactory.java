package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter.CreateTodoPresenter;


/**
 * CreateTodoInteractorFactory is an implementation of {@link CreateTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class CreateTodoInteractorFactory implements CreateTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public CreateTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public CreateTodoInteractor makeInteractorFrom(CreateTodoPresenter presenter) {
		return new CreateTodoInteraction(presenter, gatekeeper);
	}

}
