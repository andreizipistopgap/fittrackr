package com.killua.fittrackr.service;

import com.killua.fittrackr.dto.HealthResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HealthService {

    public HealthResponse getHealthStatus() {
        return new HealthResponse("OK", "fittrackr");
    }
}