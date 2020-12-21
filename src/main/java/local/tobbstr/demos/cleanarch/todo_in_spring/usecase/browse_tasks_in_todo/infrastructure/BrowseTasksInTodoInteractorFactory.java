package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoPresenter;

/**
 * BrowseTasksInTodoInteractorFactory is an implementation of {@link BrowseTasksInTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class BrowseTasksInTodoInteractorFactory implements BrowseTasksInTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public BrowseTasksInTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public BrowseTasksInTodoInteractor makeInteractorFrom(BrowseTasksInTodoPresenter presenter) {
		return new BrowseTasksInTodoInteraction(presenter, gatekeeper);
	}

}
