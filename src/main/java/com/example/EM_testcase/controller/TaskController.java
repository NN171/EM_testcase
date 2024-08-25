package com.example.EM_testcase.controller;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import com.example.EM_testcase.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/effective/tasks")
public class TaskController {

    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody CreateTaskDto createTask) {
        Task newTask = taskService.saveTask(createTask);
        return new ResponseEntity<>(newTask, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id,
                                           @RequestBody UpdateTaskDto updateTask) {
        Task editedTask = taskService.updateTask(id, updateTask);
        return new ResponseEntity<>(editedTask, HttpStatus.OK);
    }
}