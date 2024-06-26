package it.ioprogrammatore.task.models;

import java.time.LocalDate;

public class Task {
    private String description;
    private LocalDate dueDate;
    private int priority;

    public Task() {
    }

    public Task(String description, LocalDate dueDate, int priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Task description(String description) {
        this.description = description;
        return this;
    }

    public Task dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task priority(int priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                '}';
    }
}
