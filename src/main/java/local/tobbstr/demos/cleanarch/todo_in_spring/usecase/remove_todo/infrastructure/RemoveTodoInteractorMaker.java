package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface RemoveTodoInteractorMaker {
	public RemoveTodoInteractor makeInteractorFrom(RemoveTodoPresenter presenter);
}
