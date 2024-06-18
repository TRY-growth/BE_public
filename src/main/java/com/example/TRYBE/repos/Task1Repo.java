package com.example.TRYBE.repos;

import com.example.TRYBE.entities.Task1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Task1Repo extends JpaRepository<Task1, String> {
    Task1 findByTaskId(String taskId);
}
