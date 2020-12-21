package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoPresenter}
 * @author tobias
 *
 */
public interface UpdateTaskInTodoPresenter {
	public void updateTaskInTodo(UpdateTaskInTodoResModel resModel);
}
