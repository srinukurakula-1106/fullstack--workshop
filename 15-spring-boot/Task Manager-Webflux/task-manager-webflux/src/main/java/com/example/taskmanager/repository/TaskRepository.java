package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private static long counter = 1;

    public Flux<Task> findAll() {
        return Flux.fromIterable(tasks.values());
    }

    public Mono<Task> findById(Long id) {
        return Mono.justOrEmpty(tasks.get(id));
    }

    public Mono<Task> save(Task task) {
        task.setId(counter++);
        tasks.put(task.getId(), task);
        return Mono.just(task);
    }

    public Mono<Void> delete(Long id) {
        tasks.remove(id);
        return Mono.empty();
    }
}
