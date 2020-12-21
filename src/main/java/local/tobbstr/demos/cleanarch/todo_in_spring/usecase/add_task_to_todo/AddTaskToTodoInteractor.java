package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo;

/**
 * AddTaskToTodoInteractor is a Clean Architecture Input Boundary interface, also known
 * as an Interactor. The Interactor's purpose is to orchestrate the dance of the entities
 * for a particular use case.
 * In other words, to orchestrate the sequence of actions defining a use case.
 * Such actions might e.g. include getting data from a Gateway, check conditions (enforcing
 * business rules) and construct a Response Model, which it passes to its encapsulated
 * Presenter. Interactors only expose one method, which takes a Request Model as argument.
 * In some cases however, the Interactor's method is void of arguments. For an example,
 * see the BrowseTodos use case in this project.
 * @author tobias
 *
 */
public interface AddTaskToTodoInteractor {
	void addTaskToTodo(AddTaskToTodoReqModel reqModel);
}
