package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.adapter.BrowseTodosPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.adapter.BrowseTodosPresenter;

/**
 * BrowseTodosPresenterFactory is an implementation of {@link BrowseTodosPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class BrowseTodosPresenterFactory implements BrowseTodosPresenterMaker {

	@Override
	public BrowseTodosPresenter makePresenter() {
		return new BrowseTodosPresentation();
	}

}
