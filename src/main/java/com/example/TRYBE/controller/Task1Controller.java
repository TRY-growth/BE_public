package com.example.TRYBE.controller;

import com.example.TRYBE.entities.Task1;
import com.example.TRYBE.services.Task1Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task/1")
@Tag(name = "01", description = "Task APIs")
public class Task1Controller {
    private final Task1Service task1Service;

    @Autowired
    public Task1Controller(Task1Service task1Service) {
        this.task1Service = task1Service;
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "taskId로 Task1 문제 조회")
    public ResponseEntity<Task1> getTask1ByTask1Id(@PathVariable String taskId){
        Task1 task1 = task1Service.findByTaskId(taskId);

        if(task1 != null){
            return new ResponseEntity<>(task1, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
