package com.example.TRYBE.repos;

import com.example.TRYBE.entities.Task3;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Task3Repo extends JpaRepository<Task3,String> {
    Task3 findByTaskId(String taskId);
}
