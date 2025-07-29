package com.example.bajaj.controller;

import com.example.bajaj.service.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @Autowired
    private WebhookService webhookService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Application is running!");
    }

    @PostMapping("/execute")
    public ResponseEntity<String> executeWebhookFlow() {
        try {
            webhookService.executeFlow();
            return ResponseEntity.ok("Webhook flow executed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error executing webhook flow: " + e.getMessage());
        }
    }
}
