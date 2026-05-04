package com.killua.fittrackr.service;

import com.killua.fittrackr.dto.ExerciseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    public List<ExerciseResponse> getExercises() {
        return List.of(
            new ExerciseResponse("Bench Press", "CHEST"),
            new ExerciseResponse("Squat", "LEGS"),
            new ExerciseResponse("Deadlift", "BACK")
        );
    }
}