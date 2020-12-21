package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface BrowseTasksInTodoInteractorMaker {
	public BrowseTasksInTodoInteractor makeInteractorFrom(BrowseTasksInTodoPresenter presenter);
}
