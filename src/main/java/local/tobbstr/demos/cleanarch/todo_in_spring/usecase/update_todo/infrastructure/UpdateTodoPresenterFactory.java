package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter.UpdateTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter.UpdateTodoPresenter;

/**
 * UpdateTodoPresenterFactory is an implementation of {@link UpdateTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class UpdateTodoPresenterFactory implements UpdateTodoPresenterMaker {

	@Override
	public UpdateTodoPresenter makePresenter() {
		return new UpdateTodoPresentation();
	}

}
