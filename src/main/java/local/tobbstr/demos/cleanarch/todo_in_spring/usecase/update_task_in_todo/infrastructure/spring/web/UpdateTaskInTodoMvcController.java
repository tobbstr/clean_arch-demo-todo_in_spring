package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.adapter.UpdateTaskInTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure.UpdateTaskInTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infrastructure.UpdateTaskInTodoPresenterMaker;

@RestController
public class UpdateTaskInTodoMvcController {
	private final UpdateTaskInTodoPresenterMaker presenterMaker;
	private final UpdateTaskInTodoInteractorMaker interactorMaker;
	
	public UpdateTaskInTodoMvcController(UpdateTaskInTodoPresenterMaker presenterMaker,
			UpdateTaskInTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@PutMapping(path = "/todos/{todoId}/tasks/{taskId}")
	public ResponseEntity<UpdateTaskInTodoViewModel> updateTodo(@PathVariable UUID taskId,
			@RequestBody UpdateTaskInTodoMvcModel mvcModel) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new UpdateTaskInTodoReqModel(taskId, mvcModel.getTitle(), mvcModel.getDescription());
		
		try {
			interactor.updateTaskInTodo(reqModel);
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
