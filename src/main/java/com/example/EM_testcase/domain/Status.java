package com.example.EM_testcase.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    WAITING ("В ожидании"),
    WORKING ("В процессе"),
    DONE ("Завершено");

    private final String status;

    //TODO сделать строковую запись
}
