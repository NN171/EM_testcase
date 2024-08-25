package com.example.EM_testcase.service.impl;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.model.repository.TaskRepository;
import com.example.EM_testcase.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(CreateTaskDto createTask) {
        return taskRepository.save(createTask);
    }
}
