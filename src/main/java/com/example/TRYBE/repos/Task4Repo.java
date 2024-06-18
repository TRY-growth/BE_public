package com.example.TRYBE.repos;

import com.example.TRYBE.entities.Task4;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Task4Repo extends JpaRepository<Task4,String> {
    Task4 findByTaskId(String taskId);
}
