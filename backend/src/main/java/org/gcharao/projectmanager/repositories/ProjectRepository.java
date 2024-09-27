package org.gcharao.projectmanager.repositories;

import org.gcharao.projectmanager.entities.Project;
import org.gcharao.projectmanager.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findById(Long id);
    Optional<Project> findByStatus(Status status);
}
