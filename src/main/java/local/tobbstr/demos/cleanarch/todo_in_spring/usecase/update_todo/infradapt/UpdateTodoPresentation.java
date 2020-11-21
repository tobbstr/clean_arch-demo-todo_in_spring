package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoResModel;

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
