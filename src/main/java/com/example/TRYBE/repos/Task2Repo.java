package com.example.TRYBE.repos;

import com.example.TRYBE.entities.Task2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Task2Repo extends JpaRepository<Task2,String> {
    Task2 findByTaskId(String taskId);
}
