package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoPresenter;

/**
 * RemoveTaskFromTodoInteractorFactory is an implementation of {@link RemoveTaskFromTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class RemoveTaskFromTodoInteractorFactory implements RemoveTaskFromTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public RemoveTaskFromTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public RemoveTaskFromTodoInteractor makeInteractorFrom(RemoveTaskFromTodoPresenter presenter) {
		return new RemoveTaskFromTodoInteraction(presenter, gatekeeper);
	}

}
