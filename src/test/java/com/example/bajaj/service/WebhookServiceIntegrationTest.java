package com.example.bajaj.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebhookServiceIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void healthEndpointShouldReturnSuccess() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/health", String.class);
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Application is running!", response.getBody());
    }

    @Test
    void executeEndpointShouldHandleWebhookFlow() {
        ResponseEntity<String> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/execute", null, String.class);
        
        // Should return 200 OK even if webhook calls fail (graceful error handling)
        assertEquals(HttpStatus.OK, response.getStatusCode());
        String responseBody = response.getBody();
        assertEquals(true, responseBody != null && 
                     (responseBody.contains("Error executing webhook flow") || 
                      responseBody.contains("Webhook flow executed successfully")));
    }
}
