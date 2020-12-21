package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.adapter.BrowseTasksInTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure.BrowseTasksInTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infrastructure.BrowseTasksInTodoPresenterMaker;

@RestController
public class BrowseTasksInTodoMvcController {
	private final BrowseTasksInTodoPresenterMaker presenterMaker;
	private final BrowseTasksInTodoInteractorMaker interactorMaker;
	
	public BrowseTasksInTodoMvcController(BrowseTasksInTodoPresenterMaker presenterMaker,
			BrowseTasksInTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@GetMapping(path = "/todos/{todoId}/tasks")
	public ResponseEntity<BrowseTasksInTodoViewModel> browseTasksInTodo(@PathVariable UUID todoId) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new BrowseTasksInTodoReqModel(todoId);
		
		try {
			interactor.browseTasksInTodo(reqModel);
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}
		
		return ResponseEntity.ok(presenter.getViewModel());
	}
}
