package com.example.testing.spock_lab.repository;

import com.example.testing.spock_lab.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
