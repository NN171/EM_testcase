package com.example.EM_testcase.service;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;

public interface TaskService {
    Task saveTask(CreateTaskDto createTask);
    Task updateTask(Long id, UpdateTaskDto updateTask);
}
