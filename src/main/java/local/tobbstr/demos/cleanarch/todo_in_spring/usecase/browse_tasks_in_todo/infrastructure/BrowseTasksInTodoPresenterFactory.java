package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter.BrowseTasksInTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter.BrowseTasksInTodoPresenter;

/**
 * BrowseTasksInTodoPresenterFactory is an implementation of {@link BrowseTasksInTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class BrowseTasksInTodoPresenterFactory implements BrowseTasksInTodoPresenterMaker {

	@Override
	public BrowseTasksInTodoPresenter makePresenter() {
		return new BrowseTasksInTodoPresentation();
	}

}
