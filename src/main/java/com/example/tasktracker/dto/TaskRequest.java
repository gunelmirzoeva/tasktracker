package com.example.tasktracker.dto;

import com.example.tasktracker.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 50, message = "Title cannot exceed 50 characters")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 150, message = "Description cannot exceed 150 characters")
    private String description;

    @NotNull
    private Status status;
}
