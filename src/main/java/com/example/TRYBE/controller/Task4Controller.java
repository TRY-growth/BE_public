package com.example.TRYBE.controller;

import com.example.TRYBE.entities.Task4;
import com.example.TRYBE.services.Task4Service;
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
@RequestMapping("/task/4")
@Tag(name = "01")
public class Task4Controller {
    private final Task4Service task4Service;

    @Autowired
    public Task4Controller(Task4Service task4Service) {
        this.task4Service = task4Service;
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "taskId로 Task4 문제 조회")
    public ResponseEntity<Task4> getTask4ByTask4Id(@PathVariable String taskId){
        Task4 task4 = task4Service.findByTaskId(taskId);

        if(task4 != null){
            return new ResponseEntity<>(task4, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
