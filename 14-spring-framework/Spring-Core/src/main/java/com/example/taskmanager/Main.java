package com.example.taskmanager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter task :");
        String task = sc.nextLine();

        // ONLY print content
        System.out.println(task);
    }
}
