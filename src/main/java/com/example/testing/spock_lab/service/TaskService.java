package com.example.testing.spock_lab.service;

import com.example.testing.spock_lab.dto.TaskRequestDTO;
import com.example.testing.spock_lab.dto.TaskResponseDTO;
import com.example.testing.spock_lab.model.Task;
import com.example.testing.spock_lab.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public TaskResponseDTO updateTask(Long id, @Valid TaskRequestDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());

        Task updated = repository.save(task);
        return toResponseDto(updated);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<TaskResponseDTO> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    private TaskResponseDTO toResponseDto(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority()
        );
    }
}
