package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter.BrowseTasksInTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
public interface BrowseTasksInTodoPresenterMaker {
	public BrowseTasksInTodoPresenter makePresenter();
}
