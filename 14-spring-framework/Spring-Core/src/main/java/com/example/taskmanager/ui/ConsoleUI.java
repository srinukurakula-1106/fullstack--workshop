package com.example.taskmanager.ui;

import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleUI {

    private final TaskService taskService;

    @Autowired
    public ConsoleUI(TaskService taskService) {
        this.taskService = taskService;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter task: ");
        String task = sc.nextLine();
        taskService.createTask(task);
    }
}