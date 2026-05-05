package com.killua.fittrackr.controller;

import com.killua.fittrackr.dto.CreateExerciseRequest;
import com.killua.fittrackr.dto.ExerciseResponse;
import com.killua.fittrackr.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/api/exercises")
    public List<ExerciseResponse> getExercises() {
        return exerciseService.getExercises();
    }

    @PostMapping("/api/exercises")
    public ExerciseResponse createExercise(@RequestBody @Valid CreateExerciseRequest request) {
        return exerciseService.createExercise(request);
    }

    @GetMapping("/api/exercises/{id}")
    public ExerciseResponse getExerciseById(@PathVariable int id) {
        return exerciseService.getExerciseById(id);
    }

    @DeleteMapping("/api/exercises/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExerciseById(@PathVariable int id) {
        exerciseService.deleteExerciseById(id);
    }

    @PutMapping("/api/exercises/{id}")
    public ExerciseResponse updateExercise(
            @PathVariable int id,
            @RequestBody @Valid CreateExerciseRequest request
    ) {
        return exerciseService.updateExercise(id, request);
    }
}