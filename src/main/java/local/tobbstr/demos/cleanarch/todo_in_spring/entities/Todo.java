package local.tobbstr.demos.cleanarch.todo_in_spring.entities;

import java.time.Instant;
import java.util.UUID;

import javax.naming.SizeLimitExceededException;

/**
 * Todo is an Entity that models Todo business objects. As there are business rules
 * when adding Tasks to a Todo and might be in future versions of this app when removing and updating
 * Tasks, these business rules related methods belong to this entity. 
 *
 */
public class Todo {
	private UUID id;
	private String title;
	private int noTasks;
	private Instant created;
	private Instant modified;
	
	public Todo(UUID id, String title, int noTasks, Instant created, Instant modified) {
		Bounce.Null(id, title);
		Bounce.emptyString(title);
		this.id = id;
		this.title = title;
		this.noTasks = noTasks;
		this.created = created;
		this.modified = modified;
	}
	
	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		modified = Instant.now();
	}

	public int getNoTasks() {
		return noTasks;
	}

	public Instant getCreated() {
		return created;
	}

	public Instant getModified() {
		return modified;
	}

	/**
	 * addTask is a pure business rules method, which is delivery mechanism agnostic. As its name
	 * implies it is to be called when adding a new Task to a Todo. It only contains business rules.
	 * Imagine for example, that this Todo app has a free and paid version. An example of a business
	 * rule could be that the free version should only allow a maximum of three Tasks. 
	 * @param task is the Task to be added
	 * @throws SizeLimitExceededException
	 */
	public void addTask(Task task) throws SizeLimitExceededException {
		// Checks free version Task limit
		if (noTasks >= 3) {
			throw new SizeLimitExceededException("could not add Task, maximum of three reached");
		}
		modified = Instant.now();
	}
	
	/**
	 * removeTask is a pure business rules method, which is delivery mechanism agnostic.
	 * In this version of the app there are no business rules when removing a Task, which is why
	 * this method contains such little code.
	 * @param task is the task to be rmeoved
	 */
	public void removeTask(Task task) {
		modified = Instant.now();
	}
	
	/**
	 * updateTask is a pure business rules method, which is delivery mechanism agnostic.
	 * In this version of the app there are no business rules when updating a Task, which is why
	 * this method contains such little code.
	 * @param task is the Task to be udpated
	 */
	public void updateTask(Task task) {
		this.modified = Instant.now();
	}
}
