package local.tobbstr.demos.cleanarch.todo_in_spring.infrastructure.http.spring.web;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.TodoPersistenceGatekeeper;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.AddTaskToTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infradapt.AddTaskToTodoMvcModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infradapt.AddTaskToTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.add_task_to_todo.infradapt.AddTaskToTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.BrowseTasksInTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infradapt.BrowseTasksInTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_tasks_in_todo.infradapt.BrowseTasksInTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.BrowseTodosInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infradapt.BrowseTodosPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.browse_todos.infradapt.BrowseTodosViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.CreateTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infradapt.CreateTodoMvcModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infradapt.CreateTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.create_todo.infradapt.CreateTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.RemoveTaskFromTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infradapt.RemoveTaskFromTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_task_from_todo.infradapt.RemoveTaskFromTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.RemoveTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infradapt.RemoveTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.remove_todo.infradapt.RemoveTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.UpdateTaskInTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infradapt.UpdateTaskInTodoMvcModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infradapt.UpdateTaskInTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_task_in_todo.infradapt.UpdateTaskInTodoViewModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoInteraction;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.UpdateTodoReqModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt.UpdateTodoMvcModel;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt.UpdateTodoPresentation;
import local.tobbstr.demos.cleanarch.todo_in_spring.usecase.update_todo.infradapt.UpdateTodoViewModel;

@RestController
public class TodoMvcController {
	private TodoPersistenceGatekeeper gatekeeper;
	
	public TodoMvcController(TodoPersistenceGatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}
	
	@GetMapping(path = "/todos")
	public ResponseEntity<BrowseTodosViewModel> BrowseTodos() {
		// Clean Architecture setup.
		// Note that since the Presenter is stateful i.e. has a member in the form of the
		// ViewModel, neither the Presenter nor the Interactor can be members of the RestController.
		// Instead they have to be instantiated manually for every HTTP request. The TodoGatekeeper on
		// the other hand, is stateless and as such it can be injected by Spring at construction of
		// the RestController.
		var presenter = new BrowseTodosPresentation();
		var interactor = new BrowseTodosInteraction(presenter, gatekeeper);
		
		try {
			interactor.browseTodos();
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}

		// Gets ViewModel
		var viewModel = presenter.getViewModel();

		// Sends successful response to user
		return ResponseEntity.ok(viewModel);
	}

	@PostMapping(path = "/todos")
	public ResponseEntity<CreateTodoViewModel> createTodo(@Valid @RequestBody CreateTodoMvcModel mvcModel) {
		var presenter = new CreateTodoPresentation();
		var interactor = new CreateTodoInteraction(presenter, gatekeeper);
		
		// Adapts user input to use case Request Model
		CreateTodoReqModel reqModel = new CreateTodoReqModel(mvcModel.getTitle());
		
		// Interactor performs the dance of the entitites
		try {
			interactor.createTodo(reqModel);
		} catch (Exception e) {
			// This catch block logs the exception by printing to System.err
			System.err.println(e.getMessage());
			// Sends error response to user
			return ResponseEntity.badRequest().body(presenter.getViewModel());
		}

		// Gets ViewModel
		var viewModel = presenter.getViewModel();

		// Sends successful response to user
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(viewModel.getTodoId())
				.toUri())
				.body(viewModel);
	}
	
	@DeleteMapping(path = "/todos/{id}")
	public ResponseEntity<RemoveTodoViewModel> removeTodo(@PathVariable UUID id) {
		var presenter = new RemoveTodoPresentation();
		var interactor = new RemoveTodoInteraction(presenter, gatekeeper);
		
		// Adapts user input to use case Request Model
		RemoveTodoReqModel reqModel = new RemoveTodoReqModel(id);
		
		// Interactor performs the dance of the entitites
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
	
	@PutMapping(path = "/todos/{id}")
	public ResponseEntity<UpdateTodoViewModel> updateTodo(@PathVariable UUID id, @RequestBody UpdateTodoMvcModel mvcModel) {
		var presenter = new UpdateTodoPresentation();
		var interactor = new UpdateTodoInteraction(presenter, gatekeeper);
		
		var reqModel = new UpdateTodoReqModel(id, mvcModel.getTitle());
		
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
	
	@PostMapping(path = "/todos/{todoId}/tasks")
	public ResponseEntity<AddTaskToTodoViewModel> addTaskToTodo(
			@PathVariable UUID todoId, @RequestBody AddTaskToTodoMvcModel mvcModel) {
		var presenter = new AddTaskToTodoPresentation();
		var interactor = new AddTaskToTodoInteraction(presenter, gatekeeper);
		
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
	
	@GetMapping(path = "/todos/{todoId}/tasks")
	public ResponseEntity<BrowseTasksInTodoViewModel> browseTasksInTodo(@PathVariable UUID todoId) {
		var presenter = new BrowseTasksInTodoPresentation();
		var interactor = new BrowseTasksInTodoInteraction(presenter, gatekeeper);
		
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
	
	@DeleteMapping(path = "/todos/{todoId}/tasks/{taskId}")
	public ResponseEntity<RemoveTaskFromTodoViewModel> removeTaskFromTodo(
			@PathVariable UUID todoId, @PathVariable UUID taskId) {
		var presenter = new RemoveTaskFromTodoPresentation();
		var interactor = new RemoveTaskFromTodoInteraction(presenter, gatekeeper);
		
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
	
	@PutMapping(path = "/todos/{todoId}/tasks/{taskId}")
	public ResponseEntity<UpdateTaskInTodoViewModel> updateTaskInTodo(
			@PathVariable UUID taskId, @RequestBody UpdateTaskInTodoMvcModel mvcModel) {
		var presenter = new UpdateTaskInTodoPresentation();
		var interactor = new UpdateTaskInTodoInteraction(presenter, gatekeeper);
		
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
