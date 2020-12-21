package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoResModel;

/**
 * RemoveTodoPresentation is an implementation of {@link RemoveTodoPresenter}.
 * @author tobias
 *
 */
public class RemoveTodoPresentation implements RemoveTodoPresenter {
	private RemoveTodoViewModel viewModel;

	@Override
	public void removeTodo(RemoveTodoResModel resModel) {
		viewModel = new RemoveTodoViewModel(resModel.getErrMsg());
	}

	public RemoveTodoViewModel getViewModel() {
		return viewModel;
	}

}
