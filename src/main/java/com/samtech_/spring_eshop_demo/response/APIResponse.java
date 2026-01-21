package com.samtech_.spring_eshop_demo.response;

import java.time.LocalDateTime;

public record APIResponse<T>(
        LocalDateTime timestamp,
        int status,
        String message,
        boolean isSuccess,
        T payload
) { }
