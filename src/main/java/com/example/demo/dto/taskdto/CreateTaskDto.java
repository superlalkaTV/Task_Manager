package com.example.demo.dto.taskdto;

import com.example.demo.entity.TaskStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTaskDto {

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 5, max = 100, message = "Title length must be between {min} and {max} characters")
    private String title;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 500, message = "Description length must be between {min} and {max} characters")
    private String description;

    @NotNull(message = "Task status is required")
    private TaskStatus taskStatus;

    @NotNull(message = "Assignee ID is required")
    @Min(value = 1, message = "Assignee ID must be a positive integer")
    private Long assigneId;



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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getAssigneId() {
        return assigneId;
    }

    public void setAssigneId(Long assigneId) {
        this.assigneId = assigneId;
    }
}

