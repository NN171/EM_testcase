package com.example.EM_testcase.controller;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import com.example.EM_testcase.service.TaskService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        String response = String.format("Task \"%s\" was deleted", taskService.deleteTask(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("authors/{author}")
    public ResponseEntity<List<Task>> getAllTasksByAuthor(@PathVariable String author,
                                                          @RequestParam(name = "page", defaultValue = "0") int page,
                                                          @RequestParam(name = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.by("author").ascending()
                        .and(Sort.by("executor").ascending()));

        List<Task> tasksByAuthor = taskService.getTasksByAuthor(author, pageable);
        return new ResponseEntity<>(tasksByAuthor, HttpStatus.OK);
    }

    @GetMapping("executors/{executor}")
    public ResponseEntity<List<Task>> getAllTasksByExecutor(@PathVariable String executor,
                                                            @RequestParam(name = "page", defaultValue = "0") int page,
                                                            @RequestParam(name = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.by("executor").ascending()
                        .and(Sort.by("author").ascending()));

        List<Task> tasksByExecutor = taskService.getTasksByExecutor(executor, pageable);
        return new ResponseEntity<>(tasksByExecutor, HttpStatus.OK);
    }
}