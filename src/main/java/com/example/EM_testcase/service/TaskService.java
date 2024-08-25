package com.example.EM_testcase.service;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    Task saveTask(CreateTaskDto createTask);
    Task updateTask(Long id, UpdateTaskDto updateTask);
    String deleteTask(Long id);
    List<Task> getTasksByAuthor(String role, Pageable pageable);
    List<Task> getTasksByExecutor(String role, Pageable pageable);
    boolean isExist(String header, String author, String executor);
}
