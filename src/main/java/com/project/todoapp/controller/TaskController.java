package com.project.todoapp.controller;

import com.project.todoapp.models.Task;
import com.project.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // GET: Home page with optional filter
    @GetMapping("/")
    public String getTasks(@RequestParam(defaultValue = "all") String filter, Model model) {
        List<Task> tasks = switch (filter) {
            case "active" -> taskService.getActiveTasks();
            case "completed" -> taskService.getCompletedTasks();
            default -> taskService.getAllTasks();
        };
        model.addAttribute("tasks", tasks);
        model.addAttribute("filter", filter);
        return "tasks";
    }

    // POST: Add new task with title, priority and optional due date
    @PostMapping("/")
    public String createTask(@RequestParam String title,
                             @RequestParam(required = false) String priority,
                             @RequestParam(required = false) LocalDate dueDate) {

        taskService.createTask(title, priority, dueDate);
        return "redirect:/";
    }

    // TOGGLE completion
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id,
                             @RequestParam(defaultValue = "all") String filter) {
        taskService.toggleTask(id);
        return "redirect:/?filter=" + filter;
    }

    // DELETE
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id,
                             @RequestParam(defaultValue = "all") String filter) {
        taskService.delete(id);
        return "redirect:/?filter=" + filter;
    }
}
