package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoPresentation;

/**
 * AddTaskToTodoPresenterFactory is an implementation of {@link AddTaskToTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class AddTaskToTodoPresenterFactory implements AddTaskToTodoPresenterMaker {

	@Override
	public AddTaskToTodoPresenter makePresenter() {
		return new AddTaskToTodoPresentation();
	}
}
