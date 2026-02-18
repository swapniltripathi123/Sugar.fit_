package com.sugarfit.template.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExampleResponse {
    private String status;
    private String requestId;
}
