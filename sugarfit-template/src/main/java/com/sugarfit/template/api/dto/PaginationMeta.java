package com.sugarfit.template.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationMeta {
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private long totalElements;
    private boolean hasNext;
}