package com.example.democourse.utils;

import com.example.democourse.utils.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

public class Formatter {

    public static ResponseEntity<ApiResponse> done() {
        return ResponseEntity.ok(ApiResponse.success("done"));
    }

    public static ResponseEntity<ApiResponse> ok(Object data) {
        return ResponseEntity.ok(ApiResponse.success(data));
    }
}
