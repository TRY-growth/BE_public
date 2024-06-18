package com.example.TRYBE.services;

import com.example.TRYBE.entities.Task4;
import com.example.TRYBE.repos.Task4Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task4Service {
    private final Task4Repo task4Repo;

    @Autowired
    public Task4Service(Task4Repo task4Repo) {
        this.task4Repo = task4Repo;
    }

    public Task4 findByTaskId(String taskId){
        return task4Repo.findByTaskId(taskId);
    }
}
