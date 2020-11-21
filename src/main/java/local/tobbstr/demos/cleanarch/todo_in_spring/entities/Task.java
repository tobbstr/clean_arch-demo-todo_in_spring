package local.tobbstr.demos.cleanarch.todo_in_spring.entities;

import java.time.Instant;
import java.util.UUID;

public class Task {
	private UUID id;
	private String title;
	private String description;
	private Instant created;
	private Instant modified;

	public Task(UUID id, String title, String description) {
		Bounce.Null(id, title, description);
		Bounce.emptyString(title, description);
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = Instant.now();
		this.modified = Instant.now();
	}
	
	public Task(UUID id, String title, String description, Instant created, Instant modified) {
		this(id, title, description);
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
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getCreated() {
		return created;
	}

	public Instant getModified() {
		return modified;
	}
	
	public void updateModified() {
		this.modified = Instant.now();
	}
}
