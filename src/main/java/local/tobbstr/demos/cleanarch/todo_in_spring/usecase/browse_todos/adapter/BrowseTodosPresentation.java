package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.adapter;

import java.time.LocalDateTime;
import java.time.ZoneId;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosResModel;

/**
 * BrowseTodosPresentation is an implementation of {@link BrowseTodosPresenter}.
 * @author tobias
 *
 */
public class BrowseTodosPresentation implements BrowseTodosPresenter {
	private BrowseTodosViewModel viewModel;
	
	public BrowseTodosPresentation() {
	}

	@Override
	public void browseTodos(BrowseTodosResModel resModel) {
		viewModel = new BrowseTodosViewModel();
		if (resModel.getErrMsg() != null) {
			viewModel.setError(resModel.getErrMsg());
			return;
		}
		resModel.getTodos().forEach(todo -> {
			String created = LocalDateTime.ofInstant(todo.getCreated(), ZoneId.systemDefault()).toString();
			String modified = LocalDateTime.ofInstant(todo.getModified(), ZoneId.systemDefault()).toString();
			viewModel.addTodo(todo.getId().toString(), todo.getTitle(), todo.getNoTasks(), created, modified);
		});
	}

	@Override
	public BrowseTodosViewModel getViewModel() {
		return viewModel;
	}

}
