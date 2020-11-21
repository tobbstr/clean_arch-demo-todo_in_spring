package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infradapt;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoResModel;

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
