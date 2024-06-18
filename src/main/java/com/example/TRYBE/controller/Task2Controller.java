package com.example.TRYBE.controller;

import com.example.TRYBE.entities.Task2;
import com.example.TRYBE.services.Task2Service;
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
@RequestMapping("/task/2")
@Tag(name = "01")
public class Task2Controller {
    private final Task2Service task2Service;

    @Autowired
    public Task2Controller(Task2Service task2Service) {
        this.task2Service = task2Service;
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "taskId로 Task2 문제 조회")
    public ResponseEntity<Task2> getTask2ByTask2Id(@PathVariable String taskId){
        Task2 task2 = task2Service.findByTaskId(taskId);

        if(task2 != null){
            return new ResponseEntity<>(task2, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
