package com.javagiants.todolist.models;

import java.time.LocalDate;

public class ProjectTask extends Task {
    private String projectName;

    public ProjectTask(String title, String description, LocalDate dueDate, String priority, String category, double progress, String projectName) {
        super(title, description, dueDate, priority, category, progress);
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
