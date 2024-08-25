package com.example.EM_testcase.service;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;

public interface TaskService {
    Task saveTask(CreateTaskDto createTask);
}
