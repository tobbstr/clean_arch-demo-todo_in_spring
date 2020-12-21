package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter.CreateTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface CreateTodoInteractorMaker {
	public CreateTodoInteractor makeInteractorFrom(CreateTodoPresenter presenter);
}
