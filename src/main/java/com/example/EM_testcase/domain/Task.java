package com.example.EM_testcase.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(nullable = false)
    @JsonProperty("header")
    private String header;

    @Column(nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private Status status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty("priority")
    private Priority priority;

    @Column(nullable = false)
    @JsonProperty("author")
    private String author;

    @Column(nullable = false)
    @JsonProperty("executor")
    private String executor;

    @Column
    @JsonProperty("comment")
    private String comment;
}
