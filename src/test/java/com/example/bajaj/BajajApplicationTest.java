package com.example.bajaj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "logging.level.org.springframework.web.client=DEBUG")
class BajajApplicationTest {

    @Test
    void contextLoads() {
        // This test will pass if the application context loads successfully
    }
}
