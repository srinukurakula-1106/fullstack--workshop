package com.example.taskmanager.service;

import com.example.taskmanager.exception.TaskNotFoundException;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Flux<Task> getAllTasks() {
        return repository.findAll();
    }

    public Mono<Task> getTask(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new TaskNotFoundException(id)));
    }

    public Mono<Task> createTask(Task task) {
        return repository.save(task);
    }

    public Mono<Void> deleteTask(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new TaskNotFoundException(id)))
                .then(repository.delete(id));
    }
}
