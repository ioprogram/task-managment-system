package it.ioprogrammatore.task.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description, String dueDateStr, int priority) {
        try {
            LocalDate dueDate = LocalDate.parse(dueDateStr);
            Task task = new Task(description, dueDate, priority);
            tasks.add(task);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format for task: " + description);
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addAllTasks(List<Task> taskList) {
        tasks.addAll(taskList);
    }

    public void printTasksDueTodayOrOverdue() {
        LocalDate today = LocalDate.now();
        List<Task> filteredTasks = tasks.stream()
                .filter(task -> !task.getDueDate().isAfter(today))
                .sorted((task1, task2) -> {
                    int dateComparison = task1.getDueDate().compareTo(task2.getDueDate());
                    if (dateComparison == 0) {
                        return Integer.compare(task2.getPriority(), task1.getPriority());
                    }
                    return dateComparison;
                })
                .toList();

        filteredTasks.forEach(System.out::println);
    }

    public void printAllTasks() {
        tasks.forEach(System.out::println);
    }
}
