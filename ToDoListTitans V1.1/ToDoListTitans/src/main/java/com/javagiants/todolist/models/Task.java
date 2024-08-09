package com.javagiants.todolist.models;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private String category;
    private double progress;  // Progress of the task, range from 0.0 to 100.0

    public Task(String title, String description, LocalDate dueDate, String priority, String category, double progress) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        setProgress(progress);
    }

    // Getter and Setter methods for the fields
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        if (progress < 0.0 || progress > 100.0) {
            throw new IllegalArgumentException("Progress must be between 0.0 and 100.0");
        }
        this.progress = progress;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.1f%%", title, priority, category, progress);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Double.compare(task.progress, progress) == 0 &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(category, task.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, dueDate, priority, category, progress);
    }
}