package com.yarmak;

import com.yarmak.config.VitalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//we use this annotation to avoid usage of @Configuration in config properties file
@EnableConfigurationProperties(VitalProperties.class)
public class ConsoleApplication {

    private final ConfigurableApplicationContext context;
    private final DummyMedicalService medicalService;

    @Autowired
    ConsoleApplication(final ConfigurableApplicationContext context,
                       final DummyMedicalService medicalService) {
        this.context = context;
        this.medicalService = medicalService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);

    }
}
