package com.javagiants.todolist.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> getTasksByCategory(String category) {
        return tasks.stream()
                .filter(task -> task.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Task> getTasksSortedByPriority() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getPriority))
                .collect(Collectors.toList());
    }

    public List<Task> getTasksSortedByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .collect(Collectors.toList());
    }

    public void updateTaskProgress(Task task, double progress) {
        task.setProgress(progress);
    }
}