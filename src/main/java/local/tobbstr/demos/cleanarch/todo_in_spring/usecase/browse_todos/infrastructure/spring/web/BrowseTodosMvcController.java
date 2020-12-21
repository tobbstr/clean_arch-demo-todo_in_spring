package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure.spring.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.adapter.BrowseTodosViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure.BrowseTodosInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infrastructure.BrowseTodosPresenterMaker;

@RestController
public class BrowseTodosMvcController {
	private final BrowseTodosPresenterMaker presenterMaker;
	private final BrowseTodosInteractorMaker interactorMaker;
	
	public BrowseTodosMvcController(BrowseTodosPresenterMaker presenterMaker,
			BrowseTodosInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@GetMapping(path = "/todos")
	public ResponseEntity<BrowseTodosViewModel> BrowseTodos() {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		
		try {
			interactor.browseTodos();
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}

		// Sends successful response to user
		return ResponseEntity.ok(presenter.getViewModel());
	}
}
