package com.example.bajaj.service;

import com.example.bajaj.model.WebhookResponse;
import com.example.bajaj.model.FinalQueryPayload;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class WebhookService {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void onStartup() {
        executeFlow();
    }

    public void executeFlow() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> body = new HashMap<>();
        body.put("name", "John Doe");
        body.put("regNo", "REG12347");
        body.put("email", "john@example.com");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<WebhookResponse> response = restTemplate.postForEntity(url, request, WebhookResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            String webhookUrl = response.getBody().getWebhookUrl();
            String accessToken = response.getBody().getAccessToken();

            String finalQuery = """
                SELECT 
                    P.AMOUNT AS SALARY,
                    CONCAT(E.FIRST_NAME, ' ', E.LAST_NAME) AS NAME,
                    TIMESTAMPDIFF(YEAR, E.DOB, CURDATE()) AS AGE,
                    D.DEPARTMENT_NAME
                FROM 
                    PAYMENTS P
                JOIN 
                    EMPLOYEE E ON P.EMP_ID = E.EMP_ID
                JOIN 
                    DEPARTMENT D ON E.DEPARTMENT = D.DEPARTMENT_ID
                WHERE 
                    DAY(P.PAYMENT_TIME) != 1
                ORDER BY 
                    P.AMOUNT DESC
                LIMIT 1;
                """;

            HttpHeaders postHeaders = new HttpHeaders();
            postHeaders.setContentType(MediaType.APPLICATION_JSON);
            postHeaders.setBearerAuth(accessToken);

            FinalQueryPayload queryPayload = new FinalQueryPayload(finalQuery);
            HttpEntity<FinalQueryPayload> postRequest = new HttpEntity<>(queryPayload, postHeaders);

            ResponseEntity<String> postResponse = restTemplate.postForEntity(webhookUrl, postRequest, String.class);
            System.out.println("Final query submitted. Status: " + postResponse.getStatusCode());
        } else {
            System.out.println("Failed to get webhook.");
        }
    }
}