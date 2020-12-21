package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
public interface RemoveTodoPresenterMaker {
	public RemoveTodoPresenter makePresenter();
}
