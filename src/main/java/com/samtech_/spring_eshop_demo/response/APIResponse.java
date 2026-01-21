package com.samtech_.spring_eshop_demo.response;

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
@Schema(description = "Generic API response wrapper")
public class APIResponse<T> {

    @Schema(description = "Timestamp of the response", example = "2026-01-21T14:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP status code of the response", example = "200")
    private int status;

    @Schema(description = "Response message", example = "Category fetched successfully")
    private String message;

    @Schema(description = "Indicates if the request was successful", example = "true")
    private boolean success;

    @Schema(description = "Response payload, can be object or list")
    private T payload;
}
