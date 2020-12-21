package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo;

/**
 * This interface is identical in responsibility to the interface
 * {@link local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteractor}
 * @author tobias
 *
 */
public interface BrowseTasksInTodoInteractor {
	void browseTasksInTodo(BrowseTasksInTodoReqModel reqModel);
}
