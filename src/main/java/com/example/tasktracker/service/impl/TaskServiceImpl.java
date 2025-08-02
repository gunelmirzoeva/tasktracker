package com.example.tasktracker.service.impl;

import com.example.tasktracker.dto.TaskRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.enums.Status;
import com.example.tasktracker.exception.DuplicateTaskTitleException;
import com.example.tasktracker.mapper.TaskMapper;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponse addTask(TaskRequest taskRequest) {
        if(taskRepository.existsByTitle(taskRequest.getTitle())) {
            throw new DuplicateTaskTitleException("Task with this title already exists.");
        }

        Task task = taskMapper.toEntity(taskRequest);

        Task savedTask = taskRepository.save(task);
        return taskMapper.toResponse(savedTask);

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
