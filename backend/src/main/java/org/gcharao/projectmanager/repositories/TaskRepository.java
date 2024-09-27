package org.gcharao.projectmanager.repositories;

import org.gcharao.projectmanager.entities.Task;
import org.gcharao.projectmanager.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    Optional<List<Task>> findTaskByStatus(Status status);
}
