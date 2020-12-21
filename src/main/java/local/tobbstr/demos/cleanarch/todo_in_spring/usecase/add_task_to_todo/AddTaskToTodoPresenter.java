package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo;

/**
 * AddTaskToTodoPresenter is a Clean Architecture Output Boundary interface, also known as
 * a Presenter. Its responsibility is to transform the output from the Interactor
 * (the Response Model) to a ViewModel. Data in the Response Model is in a form most
 * convenient to the Interactor and Entities, whereas data in the ViewModel should be
 * in a form most convenient to the users of the application. Examples of this might be
 * timestamps. Let's say the Interactor and Entities handle Unix time whereas the users
 * expect nicely formatted date time values, e.g. 2020-12-19. It's then the responsibility
 * of the Presenter to format the Unix time values in the Response Model to user-friendly
 * ones in the ViewModel. Presenters only have one method which accepts a Response Model 
 * argument, while returning void.
 * @author tobias
 *
 */
public interface AddTaskToTodoPresenter {
	public void addTaskToTodo(AddTaskToTodoResModel resModel);
}
