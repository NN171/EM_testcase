package com.example.EM_testcase.service.impl;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import com.example.EM_testcase.mapper.TaskMapper;
import com.example.EM_testcase.model.repository.TaskRepository;
import com.example.EM_testcase.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final ObjectMapper objectMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, ObjectMapper objectMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.objectMapper = objectMapper;
    }

    @Override
    public Task saveTask(CreateTaskDto createTask) {
        Task newTask = taskMapper.createDtoToDomain(createTask);
        return taskRepository.save(newTask);
    }

    @SneakyThrows
    @Override
    public Task updateTask(Long id, UpdateTaskDto updateTask) {
        Task foundTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("dada")); //TODO
        objectMapper.updateValue(foundTask, updateTask);
        return taskRepository.save(foundTask);
    }
}
