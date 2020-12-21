package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoResModel;

/**
 * CreateTodoPresentation is an implementation of {@link CreateTodoPresenter}.
 * @author tobias
 *
 */
public class CreateTodoPresentation implements CreateTodoPresenter {
	private CreateTodoViewModel viewModel;

	@Override
	public void createTodo(CreateTodoResModel resModel) {
		if (resModel.getErrMsg() != null) {
			viewModel = new CreateTodoViewModel(null, resModel.getErrMsg());
			return;
		}
		viewModel = new CreateTodoViewModel(resModel.getTodoId().toString(), null);
	}

	public CreateTodoViewModel getViewModel() {
		return viewModel;
	}
}
