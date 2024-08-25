package com.example.EM_testcase.exception;

public class TaskAlreadyExists extends RuntimeException {
    public TaskAlreadyExists(String message) {
        super(message);
    }
}
