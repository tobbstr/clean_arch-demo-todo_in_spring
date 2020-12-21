package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter;

/**
 * This is an extended version of the Output Boundary interface i.e.
 * the Clean Architecture Presenter in the use case layer, which adds a method for
 * getting the ViewModel. It's needed since the Presenter in the use case layer cannot
 * have any source-code dependencies to the ViewModel and yet the ViewModel has to be
 * retrievable by lower layer code which are aware of its existence.
 * @author tobias
 *
 */
public interface AddTaskToTodoPresenter extends local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoPresenter {
	public AddTaskToTodoViewModel getViewModel();
}
