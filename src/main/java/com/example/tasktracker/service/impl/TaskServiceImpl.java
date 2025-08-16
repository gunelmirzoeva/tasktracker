package com.example.tasktracker.service.impl;

import com.example.tasktracker.dto.TaskRequest;
import com.example.tasktracker.dto.TaskResponse;
import com.example.tasktracker.entity.Task;
import com.example.tasktracker.enums.Status;
import com.example.tasktracker.exception.DuplicateTaskTitleException;
import com.example.tasktracker.exception.TaskNotFoundException;
import com.example.tasktracker.mapper.TaskMapper;
import com.example.tasktracker.repository.TaskRepository;
import com.example.tasktracker.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        existingTask.setTitle(taskRequest.getTitle());
        existingTask.setStatus(taskRequest.getStatus());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setUpdatedAt(LocalDateTime.now());

        Task updatedTask = taskRepository.save(existingTask);
        return taskMapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        taskRepository.delete(existingTask);
    }

    @Override
    public TaskResponse updateStatus(Long id, Status status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        task.setStatus(status);
        task.setUpdatedAt(LocalDateTime.now());

        return taskMapper.toResponse(taskRepository.save(task));
    }



    @Override
    public List<TaskResponse> listAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public List<TaskResponse> listTasksByStatus(Status status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }
}
