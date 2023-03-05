package com.example.demo.dto.taskdto;

import com.example.demo.entity.TaskStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDto {
    @NotNull(message = "Title is required")
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 5, max = 100, message = "Title length must be between {min} and {max} characters")
    private String title;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 500, message = "Description length must be between {min} and {max} characters")
    private String description;

    @NotNull(message = "Assignee ID is required")
    @Min(value = 1, message = "Assignee ID must be a positive integer")
    private Long assigneeId;

    @NotNull(message = "Task status is required")
    private TaskStatus taskStatus;

    public TaskDto(String title, String description, Long assigneeId, TaskStatus taskStatus) {
        this.title = title;
        this.description = description;
        this.assigneeId = assigneeId;
        this.taskStatus = taskStatus;
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

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}

