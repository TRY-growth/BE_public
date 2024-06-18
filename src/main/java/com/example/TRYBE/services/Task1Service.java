package com.example.TRYBE.services;

import com.example.TRYBE.entities.Task1;
import com.example.TRYBE.repos.Task1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task1Service {
    private final Task1Repo task1Repo;

    @Autowired
    public Task1Service(Task1Repo task1Repo) {
        this.task1Repo = task1Repo;
    }

    public Task1 findByTaskId(String taskId){
        return task1Repo.findByTaskId(taskId);
    }
}