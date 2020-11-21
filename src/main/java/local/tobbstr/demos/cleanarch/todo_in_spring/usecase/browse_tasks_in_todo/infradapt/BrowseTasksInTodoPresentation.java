package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infradapt;

import java.time.LocalDateTime;
import java.time.ZoneId;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoResModel;

/**
 * BrowseTasksInTodoPresentation's responsibility is to convert the Response Model to a ViewModel.
 * Note that the Response Model uses java.time.Instants for the created and modified fields. In 
 * other words, the datetime information is in UTC format and it's this class' purpose to make it
 * more presentable to the user by converting it to local datetime format. This is an example of the
 * purpose of the Presenter.
 * @author tobias
 *
 */
public class BrowseTasksInTodoPresentation implements BrowseTasksInTodoPresenter {
	private BrowseTasksInTodoViewModel viewModel;

	@Override
	public void browseTasksInTodo(BrowseTasksInTodoResModel resModel) {
		viewModel = new BrowseTasksInTodoViewModel();
		if (resModel.getErrMsg() != null) {
			viewModel.setError(resModel.getErrMsg());
			return;
		}
		
		for (var task : resModel.getTasks()) {
			viewModel.addTask(
					task.getId().toString(), task.getTitle(), task.getDescription(),
					LocalDateTime.ofInstant(task.getCreated(), ZoneId.systemDefault()).toString(),
					LocalDateTime.ofInstant(task.getModified(), ZoneId.systemDefault()).toString());
		}
	}
	
	public BrowseTasksInTodoViewModel getViewModel() {
		return viewModel;
	}

}
