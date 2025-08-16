package com.example.tasktracker.service;

import com.example.tasktracker.dto.TaskRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.enums.Status;

import java.util.List;

public interface TaskService {
    TaskResponse addTask(TaskRequest taskRequest);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    void deleteTask(Long id);

    TaskResponse updateStatus(Long id, Status status);

    List<TaskResponse> listAllTasks();

    List<TaskResponse> listTasksByStatus(Status status);
}
