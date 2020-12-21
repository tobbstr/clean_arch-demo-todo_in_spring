package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter.CreateTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter.CreateTodoPresenter;

/**
 * CreateTodoPresenterFactory is an implementation of {@link CreateTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class CreateTodoPresenterFactory implements CreateTodoPresenterMaker {

	@Override
	public CreateTodoPresenter makePresenter() {
		return new CreateTodoPresentation();
	}

}
