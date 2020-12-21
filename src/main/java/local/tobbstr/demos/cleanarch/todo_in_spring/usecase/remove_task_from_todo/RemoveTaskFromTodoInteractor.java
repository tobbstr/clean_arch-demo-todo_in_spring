package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo;

/**
 * This interface is identical in responsibility to the interface
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteractor}
 * @author tobias
 *
 */
public interface RemoveTaskFromTodoInteractor {
	void removeTaskFromTodo(RemoveTaskFromTodoReqModel reqModel);
}
