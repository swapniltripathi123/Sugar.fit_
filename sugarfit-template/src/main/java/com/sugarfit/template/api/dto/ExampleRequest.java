package com.sugarfit.template.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExampleRequest {
    @NotBlank(message = "userId cannot be empty or null")
    private String userId;

    @NotNull(message = "value cannot be null")
    private Integer value;
}
