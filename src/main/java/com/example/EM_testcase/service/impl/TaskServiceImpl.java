package com.example.EM_testcase.service.impl;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.mapper.TaskMapper;
import com.example.EM_testcase.model.repository.TaskRepository;
import com.example.EM_testcase.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task saveTask(CreateTaskDto createTask) {
        Task newTask = taskMapper.createDtoToDomain(createTask);
        return taskRepository.save(newTask);
    }
}
