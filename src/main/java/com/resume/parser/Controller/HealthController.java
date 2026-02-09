package com.resume.parser.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Health", description = "Health check endpoints")
public class HealthController {

    @GetMapping("/health")
    @Operation(summary = "Check server health", description = "Returns the health status of the server")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Server is healthy and running")
    })
    public String checkHealth() {
        return "Server is running!";
    }
}

