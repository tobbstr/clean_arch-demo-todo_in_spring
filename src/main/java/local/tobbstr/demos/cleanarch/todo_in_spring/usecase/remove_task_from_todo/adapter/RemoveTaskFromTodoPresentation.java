package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoResModel;

/**
 * RemoveTaskFromTodoPresentation is an implementation of {@link RemoveTaskFromTodoPresenter}.
 * @author tobias
 *
 */
public class RemoveTaskFromTodoPresentation implements RemoveTaskFromTodoPresenter {
	private RemoveTaskFromTodoViewModel viewModel;

	@Override
	public void removeTaskFromTodo(RemoveTaskFromTodoResModel resModel) {
		viewModel = new RemoveTaskFromTodoViewModel(resModel.getErrMsg());
	}
	
	public RemoveTaskFromTodoViewModel getViewModel() {
		return viewModel;
	}

}
