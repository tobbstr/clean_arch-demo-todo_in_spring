package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoPresenter;

/**
 * RemoveTodoPresenterFactory is an implementation of {@link RemoveTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class RemoveTodoPresenterFactory implements RemoveTodoPresenterMaker {

	@Override
	public RemoveTodoPresenter makePresenter() {
		return new RemoveTodoPresentation();
	}

}
