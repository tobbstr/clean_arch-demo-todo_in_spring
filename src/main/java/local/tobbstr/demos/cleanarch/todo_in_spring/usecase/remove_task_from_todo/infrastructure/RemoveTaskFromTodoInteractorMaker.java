package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface RemoveTaskFromTodoInteractorMaker {
	public RemoveTaskFromTodoInteractor makeInteractorFrom(RemoveTaskFromTodoPresenter presenter);
}
