package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.adapter.UpdateTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure.UpdateTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infrastructure.UpdateTodoPresenterMaker;

@RestController
public class UpdateTodoMvcController {
	private final UpdateTodoPresenterMaker presenterMaker;
	private final UpdateTodoInteractorMaker interactorMaker;
	
	public UpdateTodoMvcController(UpdateTodoPresenterMaker presenterMaker,
			UpdateTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@PutMapping(path = "/todos/{todoId}")
	public ResponseEntity<UpdateTodoViewModel> updateTodo(@PathVariable UUID todoId,
			@RequestBody UpdateTodoMvcModel mvcModel) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new UpdateTodoReqModel(todoId, mvcModel.getTitle());
		
		try {
			interactor.updateTodo(reqModel);
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
