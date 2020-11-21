package local.tobbstr.demos.cleanarch.todo_in_spring.infrastructure.persistence.spring.data_jpa;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TaskHibernateEntity {
	@Id
	private UUID taskId;
	private String title;
	private String description;
	private Instant created;
	private Instant modified;
	@ManyToOne
	@JoinColumn(name = "todo_id", nullable = false)
	private TodoHibernateEntity todoHibernateEntity;

	public TaskHibernateEntity() {}
	
	public TaskHibernateEntity(UUID taskId, String title, String description,
			Instant created, TodoHibernateEntity todoHibernateEntity) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.created = created;
		this.todoHibernateEntity = todoHibernateEntity;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
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

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Instant getModified() {
		return modified;
	}

	public void setModified(Instant modified) {
		this.modified = modified;
	}

	public TodoHibernateEntity getTodoHibernateEntity() {
		return todoHibernateEntity;
	}

	public void setTodoHibernateEntity(TodoHibernateEntity todoHibernateEntity) {
		this.todoHibernateEntity = todoHibernateEntity;
	}

	@PrePersist
	public void onCreate() {
		var now = Instant.now();
		if (created == null) {
			created = now;
		}
		modified = now;
	}
	
	@PreUpdate
	public void onModify() {
		modified = Instant.now();
		System.out.println("TaskHibernateEntity's onModify() called");
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof TaskHibernateEntity)) {
			return false;
		}
		
		TaskHibernateEntity task = (TaskHibernateEntity) o;
		
		return task.getTaskId() == this.taskId;
	}
}
