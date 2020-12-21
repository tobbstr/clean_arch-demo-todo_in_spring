package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.adapter.BrowseTodosPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
public interface BrowseTodosPresenterMaker {
	public BrowseTodosPresenter makePresenter();
}
