package com.javagiants.todolist.models;

import java.time.LocalDate;

public class MeetingTask extends Task {
    private String meetingLocation;

    public MeetingTask(String title, String description, LocalDate dueDate, String priority, String category, double progress, String meetingLocation) {
        super(title, description, dueDate, priority, category, progress);
        this.meetingLocation = meetingLocation;
    }

    public String getMeetingLocation() {
        return meetingLocation;
    }

    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }
}
