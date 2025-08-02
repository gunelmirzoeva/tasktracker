package com.example.tasktracker.exception;

public class DuplicateTaskTitleException extends RuntimeException {
    public DuplicateTaskTitleException(String message) {
        super(message);
    }
}
