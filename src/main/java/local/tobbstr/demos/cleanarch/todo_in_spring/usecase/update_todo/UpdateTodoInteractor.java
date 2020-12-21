package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo;

/**
 * This interface is identical in responsibility to the interface
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteractor}
 * @author tobias
 *
 */
public interface UpdateTodoInteractor {
	void updateTodo(UpdateTodoReqModel reqModel);
}
