package local.tobbstr.demos.cleanarch.todo_in_spring.infrastructure.persistence.spring.data_jpa;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class TodoHibernateEntity {
	@Id
	private UUID todoId;
	private String title;
	private Instant created;
	private Instant modified;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "todoHibernateEntity",
			orphanRemoval = true)
	private List<TaskHibernateEntity> taskHibernateEntities = new ArrayList<>();
	
	public TodoHibernateEntity() {}
	
	public TodoHibernateEntity(UUID id, String title, Instant created) {
		this.todoId = id;
		this.title = title;
		this.created = created;
	}
	
	public UUID getTodoId() {
		return todoId;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Instant getCreated() {
		return created;
	}

	public Instant getModified() {
		return modified;
	}

	public List<TaskHibernateEntity> getTaskHibernateEntities() {
		return taskHibernateEntities;
	}
	
	public void addTaskHibernateEntity(TaskHibernateEntity task) {
		task.setTodoHibernateEntity(this);
		taskHibernateEntities.add(task);
	}
	
	public void removeTaskHibernateEntity(TaskHibernateEntity task) {
		task.setTodoHibernateEntity(null);
		taskHibernateEntities.remove(task);
	}
	
	@PreUpdate
	public void onModify() {
		this.modified = Instant.now();
		System.out.println("TodoHibernateEntity's onModify() called");
	}
	
	@PrePersist
	public void onCreate() {
		var now = Instant.now();
		if (this.created == null) {
			this.created = now;
		}
		this.modified = now;
	}
	
	public void setModifiedNow() {
		this.modified = Instant.now();
	}
}
