package com.kevinchristian.department_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@RefreshScope
public class MessageController {
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(message);
    }
}
