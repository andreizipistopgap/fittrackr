package com.killua.fittrackr.service;

import com.killua.fittrackr.dto.CreateExerciseRequest;
import com.killua.fittrackr.dto.ExerciseResponse;
import com.killua.fittrackr.exception.ExerciseNotFoundException;
import com.killua.fittrackr.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseResponse> getExercises() {
        return exerciseRepository.findAll();
    }

    public ExerciseResponse getExerciseById(int id) {
        return exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise not found with id: " + id));
    }

    public ExerciseResponse createExercise(CreateExerciseRequest request) {
        return exerciseRepository.save(request.name(), request.muscleGroup());
    }

    public ExerciseResponse updateExercise(int id, CreateExerciseRequest request) {
        ExerciseResponse updated = exerciseRepository.update(id, request.name(), request.muscleGroup());

        if (updated == null) {
            throw new ExerciseNotFoundException("Exercise not found with id: " + id);
        }

        return updated;
    }

    public void deleteExerciseById(int id) {
        boolean deleted = exerciseRepository.deleteById(id);

        if (!deleted) {
            throw new ExerciseNotFoundException("Exercise not found with id: " + id);
        }
    }
}