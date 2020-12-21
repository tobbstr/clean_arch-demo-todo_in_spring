package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter;

/**
 * This is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter}.
 * @author tobias
 *
 */
public interface RemoveTodoPresenter extends local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoPresenter {
	public RemoveTodoViewModel getViewModel();
}
