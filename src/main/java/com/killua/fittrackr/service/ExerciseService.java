package com.killua.fittrackr.service;

import com.killua.fittrackr.dto.CreateExerciseRequest;
import com.killua.fittrackr.dto.ExerciseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {

    private final List<ExerciseResponse> exercises = new ArrayList<>();

    public ExerciseService() {
        exercises.add(new ExerciseResponse("Bench Press", "CHEST"));
        exercises.add(new ExerciseResponse("Squat", "LEGS"));
        exercises.add(new ExerciseResponse("Deadlift", "BACK"));
    }

    public List<ExerciseResponse> getExercises() {
        return exercises;
    }

    public ExerciseResponse createExercise(CreateExerciseRequest request) {
        ExerciseResponse exercise = new ExerciseResponse(
            request.name(),
            request.muscleGroup()
        );
        
        exercises.add(exercise);
        return exercise;
    }
}