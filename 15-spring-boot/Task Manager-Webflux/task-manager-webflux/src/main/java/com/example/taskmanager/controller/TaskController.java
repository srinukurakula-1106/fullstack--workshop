package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // ✅ GET all tasks
    @GetMapping
    public Flux<Task> getAllTasks() {
        return service.getAllTasks();
    }

    // ✅ GET task by id
    @GetMapping("/{id}")
    public Mono<Task> getTaskById(@PathVariable Long id) {
        return service.getTask(id);
    }

    // ✅ CREATE task
    @PostMapping
    public Mono<Task> createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    // ✅ DELETE task
    @DeleteMapping("/{id}")
    public Mono<Void> deleteTask(@PathVariable Long id) {
        return service.deleteTask(id);
    }
}
