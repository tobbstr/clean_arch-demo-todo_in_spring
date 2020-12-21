package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import local.tobbstr.demos.cleanarch.todo_in_spring.entities.Task;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;

/**
 * BrowseTasksInTodoInteraction is an implementation of {@link BrowseTasksInTodoInteractor}.
 * @author tobias
 *
 */
public class BrowseTasksInTodoInteraction implements BrowseTasksInTodoInteractor {
	private BrowseTasksInTodoPresenter presenter;
	private TodoPersistenceGatekeeper gatekeeper;
	
	public BrowseTasksInTodoInteraction(BrowseTasksInTodoPresenter presenter, TodoPersistenceGatekeeper gatekeeper) {
		this.presenter = presenter;
		this.gatekeeper = gatekeeper;
	}

	/**
	 * browseTasksInTodo browses Task entities in Todo
	 * @param reqModel is a clean architecture request model
	 * @return BrowseTasksInTodoResModel
	 * @throws RuntimeException if any errors occur
	 */
	@Override
	public void browseTasksInTodo(BrowseTasksInTodoReqModel reqModel) {
		// Finds Tasks in persistence store
		try {
			var tasks = gatekeeper.findTasksByTodoId(reqModel.getTodoId());
			List<BrowseTasksInTodoResModel.Task> resModelTasks = new ArrayList<BrowseTasksInTodoResModel.Task>();
			for (Task task : tasks) {
				BrowseTasksInTodoResModel.Task resModelTask = new BrowseTasksInTodoResModel.Task(
						task.getId(), task.getTitle(), task.getDescription(),
						task.getCreated(), task.getModified()
						);
				resModelTasks.add(resModelTask);
			}
			presenter.browseTasksInTodo(new BrowseTasksInTodoResModel(resModelTasks, null));
		} catch (Exception e) {
			presenter.browseTasksInTodo(new BrowseTasksInTodoResModel(Collections.emptyList(),
					"could not get Tasks from persistence store"));
			throw new RuntimeException(
					String.format("could not find Tasks for Todo with Id[%s]: %s", reqModel.getTodoId(), e.getMessage()), e);
		}
	}
}
