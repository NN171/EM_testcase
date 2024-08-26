package com.example.EM_testcase.model.dto;

import com.example.EM_testcase.model.domain.Priority;
import com.example.EM_testcase.model.domain.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateTaskDto {

    @JsonProperty("header")
    private String header;

    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonProperty("priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @JsonProperty("author")
    private String author;

    @JsonProperty("executor")
    private String executor;

    @JsonProperty("comment")
    private String comment;
}

