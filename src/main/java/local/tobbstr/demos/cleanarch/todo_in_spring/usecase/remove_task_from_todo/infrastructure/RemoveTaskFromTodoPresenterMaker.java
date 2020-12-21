package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoPresenter;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
public interface RemoveTaskFromTodoPresenterMaker {
	public RemoveTaskFromTodoPresenter makePresenter();

}
