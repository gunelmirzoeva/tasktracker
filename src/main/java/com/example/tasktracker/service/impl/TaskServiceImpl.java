package com.example.tasktracker.service.impl;

import com.example.tasktracker.dto.TaskRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.enums.Status;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        return null;
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public TaskResponse markAsInProgress(Long id) {
        return null;
    }

    @Override
    public TaskResponse markAsDone(Long id) {
        return null;
    }

    @Override
    public List<TaskResponse> listAllTasks() {
        return List.of();
    }

    @Override
    public List<TaskResponse> listTasksByStatus(Status status) {
        return List.of();
    }
}
