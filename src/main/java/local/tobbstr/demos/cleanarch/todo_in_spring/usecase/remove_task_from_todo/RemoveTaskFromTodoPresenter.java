package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

/**
 * This interface is identical in responsibility to
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoPresenter}
 * @author tobias
 *
 */
public interface RemoveTaskFromTodoPresenter {
	public void removeTaskFromTodo(RemoveTaskFromTodoResModel resModel);
}
