package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter.UpdateTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
public interface UpdateTodoPresenterMaker {
	public UpdateTodoPresenter makePresenter();
}
