package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure;

import org.springframework.stereotype.Component;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter.UpdateTaskInTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter.UpdateTaskInTodoPresenter;

/**
 * UpdateTaskInTodoPresenterFactory is an implementation of {@link UpdateTaskInTodoPresenterMaker}.
 * @author tobias
 *
 */
@Component
public class UpdateTaskInTodoPresenterFactory implements UpdateTaskInTodoPresenterMaker{

	@Override
	public UpdateTaskInTodoPresenter makePresenter() {
		return new UpdateTaskInTodoPresentation();
	}

}
