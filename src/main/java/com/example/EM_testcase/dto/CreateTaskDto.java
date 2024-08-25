package com.example.EM_testcase.dto;

import com.example.EM_testcase.domain.Priority;
import com.example.EM_testcase.domain.Status;
import lombok.Data;

@Data
public class CreateTaskDto {

    private String header;

    private String description;

    private Status status;

    private Priority priority;

    private String author;

    private String executor;
}
