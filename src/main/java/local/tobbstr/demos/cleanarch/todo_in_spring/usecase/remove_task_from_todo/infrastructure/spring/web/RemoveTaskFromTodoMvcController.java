package local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure.spring.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.adapter.RemoveTaskFromTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure.RemoveTaskFromTodoInteractorMaker;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infrastructure.RemoveTaskFromTodoPresenterMaker;

@RestController
public class RemoveTaskFromTodoMvcController {
	private final RemoveTaskFromTodoPresenterMaker presenterMaker;
	private final RemoveTaskFromTodoInteractorMaker interactorMaker;
	
	public RemoveTaskFromTodoMvcController(RemoveTaskFromTodoPresenterMaker presenterMaker,
			RemoveTaskFromTodoInteractorMaker interactorMaker) {
		this.presenterMaker = presenterMaker;
		this.interactorMaker = interactorMaker;
	}

	@DeleteMapping(path = "/todos/{todoId}/tasks/{taskId}")
	public ResponseEntity<RemoveTaskFromTodoViewModel> removeTaskFromTodo(@PathVariable UUID taskId) {
		var presenter = presenterMaker.makePresenter();
		var interactor = interactorMaker.makeInteractorFrom(presenter);
		var reqModel = new RemoveTaskFromTodoReqModel(taskId);
		
		try {
			interactor.removeTaskFromTodo(reqModel);
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}
		
		return ResponseEntity.ok(presenter.getViewModel());
	}
}
