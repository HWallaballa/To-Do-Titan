package com.javagiants.todolist.controllers;

import com.javagiants.todolist.models.Task;
import com.javagiants.todolist.models.TaskList;
import com.javagiants.todolist.models.MeetingTask;
import com.javagiants.todolist.models.ProjectTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class TaskController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionField;

    @FXML
    private DatePicker dueDateField;

    @FXML
    private ComboBox<String> priorityField;

    @FXML
    private ComboBox<String> categoryField;

    @FXML
    private Slider progressSlider;

    @FXML
    private ListView<Task> taskListView;

    private TaskList taskList;

    public TaskController() {
        taskList = new TaskList();
    }

    @FXML
    public void initialize() {
        // Initialize priority and category combo boxes
        ObservableList<String> priorityOptions = FXCollections.observableArrayList("High", "Medium", "Low");
        priorityField.setItems(priorityOptions);
        
        ObservableList<String> categoryOptions = FXCollections.observableArrayList("Work", "Personal", "School");
        categoryField.setItems(categoryOptions);

        // Initialize ListView to display tasks
        updateTaskListView();
    }

    @FXML
    public void handleAddTask() {
        String title = titleField.getText();
        String description = descriptionField.getText();
        LocalDate dueDate = dueDateField.getValue();
        String priority = priorityField.getValue();
        String category = categoryField.getValue();
        double progress = progressSlider.getValue();

        Task newTask;
        if (category.equals("Work")) {
            newTask = new ProjectTask(title, description, dueDate, priority, category, progress, "Default Project");
        } else if (category.equals("Personal")) {
            newTask = new MeetingTask(title, description, dueDate, priority, category, progress, "Default Location");
        } else {
            newTask = new Task(title, description, dueDate, priority, category, progress);
        }

        taskList.addTask(newTask);

        updateTaskListView();
        clearFormFields();
    }

    private void updateTaskListView() {
        List<Task> tasks = taskList.getTasks();
        taskListView.setItems(FXCollections.observableArrayList(tasks));
    }

    private void clearFormFields() {
        titleField.clear();
        descriptionField.clear();
        dueDateField.setValue(null);
        priorityField.setValue(null);
        categoryField.setValue(null);
        progressSlider.setValue(0);
    }

    @FXML
    public void handleRemoveTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            taskList.removeTask(selectedTask);
            updateTaskListView();
        }
    }

    @FXML
    public void handleFilterByCategory() {
        String selectedCategory = categoryField.getValue();
        if (selectedCategory != null) {
            List<Task> filteredTasks = taskList.getTasksByCategory(selectedCategory);
            taskListView.setItems(FXCollections.observableArrayList(filteredTasks));
        }
    }

    @FXML
    public void handleSortByPriority() {
        List<Task> sortedTasks = taskList.getTasksSortedByPriority();
        taskListView.setItems(FXCollections.observableArrayList(sortedTasks));
    }

    @FXML
    public void handleSortByDueDate() {
        List<Task> sortedTasks = taskList.getTasksSortedByDueDate();
        taskListView.setItems(FXCollections.observableArrayList(sortedTasks));
    }

    @FXML
    public void handleUpdateProgress() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            double newProgress = progressSlider.getValue();
            taskList.updateTaskProgress(selectedTask, newProgress);
            updateTaskListView();
        }
    }
}