package com.example.EM_testcase.service.impl;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import com.example.EM_testcase.exception.TaskAlreadyExists;
import com.example.EM_testcase.exception.TaskNotFoundException;
import com.example.EM_testcase.mapper.TaskMapper;
import com.example.EM_testcase.model.repository.TaskRepository;
import com.example.EM_testcase.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        String header = newTask.getHeader();
        String author = newTask.getAuthor();
        String executor = newTask.getExecutor();
        if (isExist(header, author, executor)) {
            throw new TaskAlreadyExists("Задача с таким названием уже существует");
        }
        return taskRepository.save(newTask);
    }

    @SneakyThrows
    @Override
    public Task updateTask(Long id, UpdateTaskDto updateTask) {
        Task foundTask = taskRepository.findById(id).orElseThrow(() ->
                new TaskNotFoundException("Задача " + id + " не найдена"));
        objectMapper.updateValue(foundTask, updateTask);
        return taskRepository.save(foundTask);
    }

    @Override
    public String deleteTask(Long id) {
        Task foundTask = taskRepository.findById(id).orElseThrow(() ->
                new TaskNotFoundException("Задача " + id + " не найдена"));
        String header = foundTask.getHeader();
        taskRepository.delete(foundTask);
        return header;
    }

    @Override
    public List<Task> getTasksByAuthor(String author, Pageable pageable) {
        Page<Task> page = taskRepository.findAllTasksByAuthor(author, pageable)
                .orElseThrow(() -> new TaskNotFoundException("У исполнителя " + author + " нет задач"));
        return page.getContent();
    }

    @Override
    public List<Task> getTasksByExecutor(String executor, Pageable pageable) {
        Page<Task> page = taskRepository.findAllTasksByExecutor(executor, pageable)
                .orElseThrow(() -> new TaskNotFoundException("У исполнителя " + executor + " нет задач"));
        return page.getContent();
    }

    @Override
    public boolean isExist(String header, String author, String executor) {
        return taskRepository.existsByHeaderAndAuthorAndExecutor(
                header,
                author,
                executor);
    }
}
