package com.sugarfit.template.service.impl;


import com.sugarfit.template.api.dto.GlucoseReadingRequest;
import com.sugarfit.template.api.dto.PaginatedResponse;
import com.sugarfit.template.api.dto.PaginationMeta;
import com.sugarfit.template.service.GlucoseReadingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class GlucoseReadingServiceImpl implements GlucoseReadingService {

    @Override
    public void ingestReading(String userId, String idempotencyKey, GlucoseReadingRequest request) {
        log.info("Business Logic: Ingesting reading for user: {} with Idempotency-Key: {}", userId, idempotencyKey);

        // 1. Check if idempotencyKey exists in Redis/DB. If yes, return early (Idempotency).
        // 2. Validate business rules (e.g., checking if the sensorId belongs to the userId).
        // 3. Save reading to Database.
        // 4. Cache the idempotencyKey with a TTL.

        log.debug("Successfully processed reading for user {}", userId);
    }

    @Override
    public PaginatedResponse<GlucoseReadingRequest> getReadings(String userId, Instant startDate, Instant endDate, int page, int size) {
        log.info("Business Logic: Fetching readings for user: {} from {} to {}, page: {}, size: {}",
                userId, startDate, endDate, page, size);

        // Mock logic representing an optimized SQL/Time-Series database query:
        // SELECT * FROM glucose_readings WHERE user_id = ? AND timestamp BETWEEN ? AND ?
        // ORDER BY timestamp DESC LIMIT ? OFFSET ?

        GlucoseReadingRequest mockData = new GlucoseReadingRequest();
        mockData.setSensorId("CGM-ABT-9982");
        mockData.setGlucoseLevel(105);
        mockData.setTimestamp(Instant.now());

        return PaginatedResponse.<GlucoseReadingRequest>builder()
                .data(List.of(mockData))
                .meta(PaginationMeta.builder()
                        .currentPage(page)
                        .pageSize(size)
                        .totalPages(1)
                        .totalElements(1)
                        .hasNext(false)
                        .build())
                .build();
    }
}
