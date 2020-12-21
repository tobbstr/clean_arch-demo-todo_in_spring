package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter;

import java.time.LocalDateTime;
import java.time.ZoneId;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoResModel;

/**
 * BrowseTasksInTodoPresentation is an implementation of {@link BrowseTasksInTodoPresenter}.
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
	
	@Override
	public BrowseTasksInTodoViewModel getViewModel() {
		return viewModel;
	}

}
