package com.example.testing.spock_lab.dto;


import jakarta.validation.constraints.NotBlank;

public class TaskRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String status;
    private String priority;

    // Constructors
    public TaskRequestDTO() {}

    public TaskRequestDTO(String title, String description, String status, String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }
}
