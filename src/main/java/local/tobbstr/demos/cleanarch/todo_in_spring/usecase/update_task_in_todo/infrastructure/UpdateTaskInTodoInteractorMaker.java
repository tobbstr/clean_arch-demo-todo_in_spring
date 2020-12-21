package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoInteractor;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter.UpdateTaskInTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker}.
 * @author tobias
 *
 */
public interface UpdateTaskInTodoInteractorMaker {
	public UpdateTaskInTodoInteractor makeInteractorFrom(UpdateTaskInTodoPresenter presenter);
}
