package com.javagiants.todolist.controllers;

import com.javagiants.todolist.models.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class TaskController {
    @FXML
    private TextField titleField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private void handleAddTask() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        Task task = new Task(title, description, null, "Medium", "General");
        taskListView.getItems().add(task);
        titleField.clear();
        descriptionField.clear();
    }
}
