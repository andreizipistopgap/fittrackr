package com.killua.fittrackr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.killua.fittrackr.service.HealthService;
import com.killua.fittrackr.dto.HealthResponse;

import java.util.Map;

@RestController
public class HealthController {
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/api/health")
    public HealthResponse health() {
        return healthService.getHealthStatus();
    }
}