package com.sugarfit.template.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedResponse<T> {
    private List<T> data;
    private PaginationMeta meta;

}