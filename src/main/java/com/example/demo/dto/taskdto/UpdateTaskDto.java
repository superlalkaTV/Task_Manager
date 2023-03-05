package com.example.demo.dto.taskdto;

import com.example.demo.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateTaskDto {
    @NotNull(message = "Task id cannot be null")
    private Long id;

    @NotBlank(message = "Task title cannot be blank")
    private String title;

    @NotBlank(message = "Task description cannot be blank")
    private String description;

    @NotNull(message = "Task status cannot be null")
    private TaskStatus status;

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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

