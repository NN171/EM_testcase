package com.example.EM_testcase.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Priority {
    HIGH ("Высокий"),
    MEDIUM("Средний"),
    LOW("Низкий");

    private final String priority;
}
