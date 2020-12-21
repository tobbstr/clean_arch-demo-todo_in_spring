package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoResModel;

/**
 * UpdateTaskInTodoPresentation is an implementation of {@link UpdateTaskInTodoPresenter}.
 * @author tobias
 *
 */
public class UpdateTaskInTodoPresentation implements UpdateTaskInTodoPresenter {
	private UpdateTaskInTodoViewModel viewModel;

	@Override
	public void updateTaskInTodo(UpdateTaskInTodoResModel resModel) {
		viewModel = new UpdateTaskInTodoViewModel(resModel.getErrMsg());
	}

	public UpdateTaskInTodoViewModel getViewModel() {
		return viewModel;
	}
}
