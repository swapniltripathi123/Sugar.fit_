package com.sugarfit.template.service.impl;

import com.sugarfit.template.api.dto.ExampleRequest;
import com.sugarfit.template.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
    @Override
    public void processData(ExampleRequest request) {
        log.info("Processing data for userId: {}, value: {}", request.getUserId(), request.getValue());
    }
}
