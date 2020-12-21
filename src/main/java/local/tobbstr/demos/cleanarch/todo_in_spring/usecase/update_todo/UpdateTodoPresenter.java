package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoPresenter}
 * @author tobias
 *
 */
public interface UpdateTodoPresenter {
	void updateTodo(UpdateTodoResModel resModel);
}
