package com.example.discoveryserver;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.cloud.config.enabled=false"
})
class DiscoveryServerApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void mainDelegatesToSpringApplication() {
        String[] args = {};

        try (MockedStatic<SpringApplication> springApplication = Mockito.mockStatic(SpringApplication.class)) {
            DiscoveryServerApplication.main(args);
            springApplication.verify(() -> SpringApplication.run(DiscoveryServerApplication.class, args));
        }
    }
}