package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface BrowseTodosInteractorMaker {
	public BrowseTodosInteractor makeInteractorFrom(BrowseTodosPresenter presenter);
}
