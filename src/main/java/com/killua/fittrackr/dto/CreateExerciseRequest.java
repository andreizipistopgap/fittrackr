package com.killua.fittrackr.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateExerciseRequest(
        @NotBlank String name,
        @NotBlank String muscleGroup
) {
}