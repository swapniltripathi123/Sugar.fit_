package com.sugarfit.template.api.controller;

import com.sugarfit.template.api.dto.ExampleRequest;
import com.sugarfit.template.api.dto.ExampleResponse;
import com.sugarfit.template.service.ExampleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public ResponseEntity<ExampleResponse> processExample(@Valid @RequestBody ExampleRequest request) {
        exampleService.processData(request);
        
        ExampleResponse response = ExampleResponse.builder()
                .status("SUCCESS")
                .requestId(MDC.get("requestId"))
                .build();
                
        return ResponseEntity.ok(response);
    }
}
