package org.gcharao.projectmanager.repositories;

import org.gcharao.projectmanager.entities.Activity;
import org.gcharao.projectmanager.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    Optional<Activity> findById(Long id);
    Optional<Activity> findByTasksEquals(Status status);
}
