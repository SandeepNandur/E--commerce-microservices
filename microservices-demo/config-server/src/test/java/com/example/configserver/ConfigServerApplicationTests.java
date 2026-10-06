package com.example.configserver;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.cloud.config.enabled=false",
        "eureka.client.enabled=false"
})
class ConfigServerApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void mainDelegatesToSpringApplication() {
        String[] args = {};

        try (MockedStatic<SpringApplication> springApplication = Mockito.mockStatic(SpringApplication.class)) {
            ConfigServerApplication.main(args);
            springApplication.verify(() -> SpringApplication.run(ConfigServerApplication.class, args));
        }
    }
}