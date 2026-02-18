package com.sugarfit.template.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.Instant;

@Data
public class GlucoseReadingRequest {
    @NotBlank(message = "sensorId is required")
    private String sensorId;

    @NotNull(message = "glucoseLevel is required")
    @Min(value = 20, message = "glucoseLevel seems impossibly low")
    @Max(value = 600, message = "glucoseLevel seems impossibly high")
    private Integer glucoseLevel;

    @NotNull(message = "timestamp is required")
    @PastOrPresent(message = "Reading timestamp cannot be in the future")
    private Instant timestamp;
}
