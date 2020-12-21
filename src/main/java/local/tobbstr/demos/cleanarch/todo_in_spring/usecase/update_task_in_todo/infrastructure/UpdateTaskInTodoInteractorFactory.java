package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter.UpdateTaskInTodoPresenter;

/**
 * UpdateTaskInTodoInteractorFactory is an implementation of {@link UpdateTaskInTodoInteractorMaker}.
 * @author tobias
 *
 */
@Component
public class UpdateTaskInTodoInteractorFactory implements UpdateTaskInTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public UpdateTaskInTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public UpdateTaskInTodoInteractor makeInteractorFrom(UpdateTaskInTodoPresenter presenter) {
		return new UpdateTaskInTodoInteraction(presenter, gatekeeper);
	}

}
