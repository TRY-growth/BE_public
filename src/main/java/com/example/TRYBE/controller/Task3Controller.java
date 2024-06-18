package com.example.TRYBE.controller;

import com.example.TRYBE.entities.Task3;
import com.example.TRYBE.services.Task3Service;
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
@RequestMapping("/task/3")
@Tag(name = "01")
public class Task3Controller {
    private final Task3Service task3Service;

    @Autowired
    public Task3Controller(Task3Service task3Service) {
        this.task3Service = task3Service;
    }

    @GetMapping("/{taskId}")
    @Operation(summary = "taskId로 Task3 문제 조회")
    public ResponseEntity<Task3> getTask2ByTask2Id(@PathVariable String taskId){
        Task3 task3 = task3Service.findByTaskId(taskId);

        if(task3 != null){
            return new ResponseEntity<>(task3, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
