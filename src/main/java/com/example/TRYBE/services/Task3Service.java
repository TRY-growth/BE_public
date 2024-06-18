package com.example.TRYBE.services;

import com.example.TRYBE.entities.Task3;
import com.example.TRYBE.repos.Task3Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task3Service {
    private final Task3Repo task3Repo;

    @Autowired
    public Task3Service(Task3Repo task3Repo) {
        this.task3Repo = task3Repo;
    }

    public Task3 findByTaskId(String taskId){
        return task3Repo.findByTaskId(taskId);
    }
}
