package com.project.todoapp.services;

import com.project.todoapp.models.Task;
import com.project.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get only active (not completed) tasks
    public List<Task> getActiveTasks() {
        return taskRepository.findByCompleted(false);
    }

    // Get only completed tasks
    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    // Create new task with optional priority and dueDate
    public void createTask(String title, String priority, LocalDate dueDate) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        task.setPriority(priority != null ? priority : "MEDIUM");
        task.setDueDate(dueDate);
        taskRepository.save(task);
    }

    // Toggle task completion
    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task ID: " + id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

    // Delete task
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
