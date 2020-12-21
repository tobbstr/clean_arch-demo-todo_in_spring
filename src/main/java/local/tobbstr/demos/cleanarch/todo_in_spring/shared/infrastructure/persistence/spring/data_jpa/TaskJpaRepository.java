package local.tobbstr.demos.cleanarch.todo_in_spring.shared.infrastructure.persistence.spring.data_jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<TaskHibernateEntity, UUID> {

}
