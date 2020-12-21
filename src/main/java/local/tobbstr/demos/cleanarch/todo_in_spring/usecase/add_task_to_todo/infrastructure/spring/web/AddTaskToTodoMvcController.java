package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.adapter.AddTaskToTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoPresenterMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infrastructure.AddTaskToTodoInteractorMaker;

@RestController
public class AddTaskToTodoMvcController {
	private final AddTaskToTodoPresenterMaker presenterMaker;
	private final AddTaskToTodoInteractorMaker interactorMaker;

	public AddTaskToTodoMvcController(AddTaskToTodoPresenterMaker presenterMaker,
			AddTaskToTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}
	
	@PostMapping(path = "/todos/{todoId}/tasks")
	public ResponseEntity<AddTaskToTodoViewModel> addTaskToTodo(
			@PathVariable UUID todoId, @RequestBody AddTaskToTodoMvcModel mvcModel) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new AddTaskToTodoReqModel(todoId, mvcModel.getTitle(), mvcModel.getDescription());

		try {
			interactor.addTaskToTodo(reqModel);
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}

		var viewModel = presenter.getViewModel();

		return ResponseEntity.created(
			ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(viewModel.getTaskId())
			.toUri())
			.body(viewModel);
	}
}
