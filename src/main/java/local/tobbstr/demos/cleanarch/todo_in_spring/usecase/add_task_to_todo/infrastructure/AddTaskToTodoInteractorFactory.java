package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoPresenter;

/**
 * AddTaskToTodoInteractorFactory is an implementation of {@link AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class AddTaskToTodoInteractorFactory implements AddTaskToTodoInteractorMaker {
	private final TodoPersistenceGatekeeper gatekeeper;
	
	public AddTaskToTodoInteractorFactory(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	@Override
	public AddTaskToTodoInteractor makeInteractorFrom(AddTaskToTodoPresenter presenter) {
		return new AddTaskToTodoInteraction(presenter, gatekeeper);
	}

}
