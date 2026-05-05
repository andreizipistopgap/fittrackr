package com.killua.fittrackr.service;

import com.killua.fittrackr.dto.CreateExerciseRequest;
import com.killua.fittrackr.dto.ExerciseResponse;
import org.springframework.stereotype.Service;
import com.killua.fittrackr.exception.ExerciseNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {

    private final List<ExerciseResponse> exercises = new ArrayList<>();
    private int nextId = 1;

    public ExerciseService() {
        exercises.add(new ExerciseResponse(nextId++, "Bench Press", "CHEST"));
        exercises.add(new ExerciseResponse(nextId++, "Squat", "LEGS"));
        exercises.add(new ExerciseResponse(nextId++, "Deadlift", "BACK"));
    }

    public List<ExerciseResponse> getExercises() {
        return exercises;
    }

    public ExerciseResponse createExercise(CreateExerciseRequest request) {
        ExerciseResponse exercise = new ExerciseResponse(
                nextId++,
                request.name(),
                request.muscleGroup()
        );

        exercises.add(exercise);

        return exercise;
    }

    public ExerciseResponse getExerciseById(int id) {
        for (ExerciseResponse exercise : exercises) {
            if (exercise.id() == id) {
                return exercise;
            }
        }

        throw new ExerciseNotFoundException("Exercise not found with id: " + id);
    }

    public void deleteExerciseById(int id) {
        boolean removed = exercises.removeIf(exercise -> exercise.id() == id);

        if (!removed) {
            throw new ExerciseNotFoundException("Exercise not found with id: " + id);
        }
    }
}