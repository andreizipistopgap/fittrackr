package com.killua.fittrackr.repository;

import com.killua.fittrackr.dto.ExerciseResponse;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseRepository {

    private final List<ExerciseResponse> exercises = new ArrayList<>();
    private int nextId = 1;

    public ExerciseRepository() {
        exercises.add(new ExerciseResponse(nextId++, "Bench Press", "CHEST"));
        exercises.add(new ExerciseResponse(nextId++, "Squat", "LEGS"));
        exercises.add(new ExerciseResponse(nextId++, "Deadlift", "BACK"));
    }

    public List<ExerciseResponse> findAll() {
        return exercises;
    }

    public Optional<ExerciseResponse> findById(int id) {
        return exercises.stream()
                .filter(exercise -> exercise.id() == id)
                .findFirst();
    }

    public ExerciseResponse save(String name, String muscleGroup) {
        ExerciseResponse exercise = new ExerciseResponse(nextId++, name, muscleGroup);
        exercises.add(exercise);
        return exercise;
    }

    public ExerciseResponse update(int id, String name, String muscleGroup) {
        ExerciseResponse updated = new ExerciseResponse(id, name, muscleGroup);

        for (int i = 0; i < exercises.size(); i++) {
            if (exercises.get(i).id() == id) {
                exercises.set(i, updated);
                return updated;
            }
        }

        return null;
    }

    public boolean deleteById(int id) {
        return exercises.removeIf(exercise -> exercise.id() == id);
    }
}