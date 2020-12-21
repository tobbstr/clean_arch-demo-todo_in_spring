package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoResModel;

/**
 * UpdateTodoPresentation is an implementation of {@link UpdateTodoPresenter}.
 * @author tobias
 *
 */
public class UpdateTodoPresentation implements UpdateTodoPresenter {
	private UpdateTodoViewModel viewModel;

	@Override
	public void updateTodo(UpdateTodoResModel resModel) {
		viewModel = new UpdateTodoViewModel(resModel.getErrMsg());
	}

	public UpdateTodoViewModel getViewModel() {
		return viewModel;
	}
}
