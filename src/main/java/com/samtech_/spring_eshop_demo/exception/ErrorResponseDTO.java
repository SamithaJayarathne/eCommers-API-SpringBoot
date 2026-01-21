package com.samtech_.spring_eshop_demo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Error response for failed requests")
public class ErrorResponseDTO {

    @Schema(description = "Timestamp when the error occurred", example = "2026-01-21T14:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP status code", example = "400")
    private int status;

    @Schema(description = "HTTP status reason", example = "Bad Request")
    private String error;

    @Schema(description = "Error message", example = "Category name must not be blank")
    private String message;

    @Schema(description = "API path where the error occurred", example = "/api/eshop/category")
    private String path;
}
