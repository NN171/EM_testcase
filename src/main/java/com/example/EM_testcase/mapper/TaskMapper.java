package com.example.EM_testcase.mapper;

import com.example.EM_testcase.domain.Task;
import com.example.EM_testcase.dto.CreateTaskDto;
import com.example.EM_testcase.dto.UpdateTaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task createDtoToDomain(CreateTaskDto createTaskDto);
}
