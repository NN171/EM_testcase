package com.example.EM_testcase.mapper;

import com.example.EM_testcase.model.domain.Task;
import com.example.EM_testcase.model.dto.CreateTaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task createDtoToDomain(CreateTaskDto createTaskDto);
}
