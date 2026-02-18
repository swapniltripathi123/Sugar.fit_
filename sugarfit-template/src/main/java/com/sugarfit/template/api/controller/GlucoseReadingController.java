package com.sugarfit.template.api.controller;

import com.sugarfit.template.api.dto.GlucoseReadingRequest;
import com.sugarfit.template.api.dto.PaginatedResponse;
import com.sugarfit.template.service.GlucoseReadingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/users/{userId}/readings")
@RequiredArgsConstructor
public class GlucoseReadingController {

    private final GlucoseReadingService glucoseReadingService;

    @PostMapping
    public ResponseEntity<Void> ingestReading(
            @PathVariable String userId,
            @RequestHeader(value = "Idempotency-Key", required = false) String idempotencyKey,
            @Valid @RequestBody GlucoseReadingRequest request) {

        glucoseReadingService.ingestReading(userId, idempotencyKey, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<PaginatedResponse<GlucoseReadingRequest>> getReadings(
            @PathVariable String userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {

        PaginatedResponse<GlucoseReadingRequest> response =
                glucoseReadingService.getReadings(userId, startDate, endDate, page, size);

        return ResponseEntity.ok(response);
    }
}
