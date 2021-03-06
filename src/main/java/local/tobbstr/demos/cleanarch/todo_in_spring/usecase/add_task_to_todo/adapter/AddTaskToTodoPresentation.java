package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoResModel;

/**
 * AddTaskToTodoPresentation is an implementation of {@link AddTaskToTodoPresenter}.
 * @author tobias
 *
 */
public class AddTaskToTodoPresentation implements AddTaskToTodoPresenter {
	private AddTaskToTodoViewModel viewModel;

	@Override
	public void addTaskToTodo(AddTaskToTodoResModel resModel) {
		if (resModel.getErrMsg() != null) {
			viewModel = new AddTaskToTodoViewModel(null, resModel.getErrMsg());
			return;
		}
		viewModel = new AddTaskToTodoViewModel(resModel.getTaskId().toString(), resModel.getErrMsg());
	}

	@Override
	public AddTaskToTodoViewModel getViewModel() {
		return viewModel;
	}
}
