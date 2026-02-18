package com.sugarfit.template.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
    private String requestId;
    private Instant timestamp;
}
