package com.example.EM_testcase.dto;

import com.example.EM_testcase.domain.Priority;
import com.example.EM_testcase.domain.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateTaskDto {

    @JsonProperty("header")
    private String header;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private Status status;

    @JsonProperty("priority")
    private Priority priority;

    @JsonProperty("author")
    private String author;

    @JsonProperty("executor")
    private String executor;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("comment")
    private String comment;
}
