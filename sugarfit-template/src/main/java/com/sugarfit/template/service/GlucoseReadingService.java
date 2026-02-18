package com.sugarfit.template.service;

import com.sugarfit.template.api.dto.GlucoseReadingRequest;
import com.sugarfit.template.api.dto.PaginatedResponse;

import java.time.Instant;

public interface GlucoseReadingService {
    void ingestReading(String userId, String idempotencyKey, GlucoseReadingRequest request);

    PaginatedResponse<GlucoseReadingRequest> getReadings(String userId, Instant startDate, Instant endDate, int page, int size);
}
