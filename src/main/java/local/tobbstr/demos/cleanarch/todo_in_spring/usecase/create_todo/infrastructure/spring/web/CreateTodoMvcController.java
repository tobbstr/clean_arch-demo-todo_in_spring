package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure.spring.web;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.adapter.CreateTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure.CreateTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infrastructure.CreateTodoPresenterMaker;

@RestController
public class CreateTodoMvcController {
	private final CreateTodoPresenterMaker presenterMaker;
	private final CreateTodoInteractorMaker interactorMaker;
	
	public CreateTodoMvcController(CreateTodoPresenterMaker presenterMaker,
			CreateTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@PostMapping(path = "/todos")
	public ResponseEntity<CreateTodoViewModel> createTodo(@Valid @RequestBody CreateTodoMvcModel mvcModel) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new CreateTodoReqModel(mvcModel.getTitle());
		
		try {
			interactor.createTodo(reqModel);
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}
		
		var viewModel = presenter.getViewModel();
		
		// Sends successful response to user
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(viewModel.getTodoId())
				.toUri())
				.body(viewModel);
	}
}