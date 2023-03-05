package com.example.demo.entity;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private User assignee;

    private TaskStatus taskStatus;

    public Task(Long id, String title, String description, LocalDate dueDate, User assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.assignee = assignee;
        taskStatus = TaskStatus.TODO;
    }

    public void markAsTodo() {
        this.taskStatus = TaskStatus.TODO;
    }

    public void markAsInProgress() {
        this.taskStatus = TaskStatus.IN_PROGRESS;
    }

    public void markAsCompleted() {
        this.taskStatus = TaskStatus.COMPLETED;
    }

    public void markAsCanceled() {
        this.taskStatus = TaskStatus.CANCELED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }
}

