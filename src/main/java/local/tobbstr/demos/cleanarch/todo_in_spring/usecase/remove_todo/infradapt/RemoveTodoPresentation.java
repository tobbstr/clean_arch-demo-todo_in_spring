package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infradapt;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoResModel;

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
