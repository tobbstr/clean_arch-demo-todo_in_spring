package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter;

/**
 * This is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter}.
 * @author tobias
 *
 */
public interface RemoveTaskFromTodoPresenter extends local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoPresenter {
	public RemoveTaskFromTodoViewModel getViewModel();
}
