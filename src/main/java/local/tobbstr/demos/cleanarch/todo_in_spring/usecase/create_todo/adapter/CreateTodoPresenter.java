package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter;

/**
 * This is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter}.
 * @author tobias
 *
 */
public interface CreateTodoPresenter extends local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoPresenter {
	public CreateTodoViewModel getViewModel();
}
