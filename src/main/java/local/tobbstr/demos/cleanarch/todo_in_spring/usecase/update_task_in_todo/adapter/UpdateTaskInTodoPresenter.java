package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter;

/**
 * This is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter}.
 * @author tobias
 *
 */
public interface UpdateTaskInTodoPresenter extends local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoPresenter {
	public UpdateTaskInTodoViewModel getViewModel();
}
