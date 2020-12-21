package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoPresenter;

/**
 * RemoveTaskFromTodoPresenterFactory is an implementation of {@link RemoveTaskFromTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class RemoveTaskFromTodoPresenterFactory implements RemoveTaskFromTodoPresenterMaker {

	@Override
	public RemoveTaskFromTodoPresenter makePresenter() {
		return new RemoveTaskFromTodoPresentation();
	}

}
