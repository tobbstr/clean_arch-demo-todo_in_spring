package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter;

/**
 * AddTaskToTodoPresenterMaker enables the MVC controller to instantiate Presenter
 * objects while leveraging the Spring framework for the wiring and dependency resolving.
 * This interface's implementation should be annotated with @Component or similar to
 * add it to the Spring IoC container.
 * @author tobias
 *
 */
public interface AddTaskToTodoPresenterMaker {
	public AddTaskToTodoPresenter makePresenter();
}
