package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infradapt;

import java.time.LocalDateTime;
import java.time.ZoneId;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosPresenter;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosResModel;

/**
 * BrowseTodosPresentation's responsibility is to convert the Response Model to a ViewModel.
 * Note that the Response Model uses java.time.Instants for the created and modified fields. In 
 * other words, the datetime information is in UTC format and it's this class' purpose to make it
 * more presentable to the user by converting it to local datetime format. This is an example of the
 * purpose of the Presenter.
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

	public BrowseTodosViewModel getViewModel() {
		return viewModel;
	}

}
