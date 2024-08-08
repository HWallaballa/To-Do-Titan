module com.javagiants.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javagiants.todolist to javafx.fxml;
    opens com.javagiants.todolist.controllers to javafx.fxml;
    opens com.javagiants.todolist.models to javafx.base;
    opens com.javagiants.todolist.views to javafx.fxml;

    exports com.javagiants.todolist;
    exports com.javagiants.todolist.controllers;
    exports com.javagiants.todolist.models;
    exports com.javagiants.todolist.views;
}
