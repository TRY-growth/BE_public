package com.example.TRYBE.services;

import com.example.TRYBE.entities.Task2;
import com.example.TRYBE.repos.Task2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task2Service {
    private final Task2Repo task2Repo;

    @Autowired
    public Task2Service(Task2Repo task2Repo) {
        this.task2Repo = task2Repo;
    }

    public Task2 findByTaskId(String taskId){
        return task2Repo.findByTaskId(taskId);
    }
}
