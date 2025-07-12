package com.project.todoapp.repository;

import com.project.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Custom method to filter tasks by completed status
    List<Task> findByCompleted(boolean completed);
}
