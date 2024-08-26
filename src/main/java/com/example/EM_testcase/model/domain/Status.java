package com.example.EM_testcase.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    WAITING ("В ожидании"),
    WORKING ("В процессе"),
    DONE ("Завершено");

    private final String status;

    public String toString() {
        return name().toLowerCase();
    }
    //TODO сделать строковую запись
}
