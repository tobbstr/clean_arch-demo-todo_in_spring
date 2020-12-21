package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.adapter.RemoveTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure.RemoveTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infrastructure.RemoveTodoPresenterMaker;

@RestController
public class RemoveTodoMvcController {
	private final RemoveTodoPresenterMaker presenterMaker;
	private final RemoveTodoInteractorMaker interactorMaker;
	
	public RemoveTodoMvcController(RemoveTodoPresenterMaker presenterMaker,
			RemoveTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@DeleteMapping(path = "/todos/{todoId}")
	public ResponseEntity<RemoveTodoViewModel> removeTodo(@PathVariable UUID todoId) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new RemoveTodoReqModel(todoId);
		
		try {
			interactor.removeTodo(reqModel);
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
