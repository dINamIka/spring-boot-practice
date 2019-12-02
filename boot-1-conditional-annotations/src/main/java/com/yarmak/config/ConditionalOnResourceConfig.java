package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnResourceConfig {

    @Bean
    @ConditionalOnResource(resources = "classpath:conditional-on-property/app.properties")
    DummyStorage dummyStorage() {
        return new DummyStorage("dummy storage");
    }

    // '/' is the same as 'classpath:' for resources
    @Bean
    @ConditionalOnResource(resources = "/conditional-on-property/app.properties")
    DummyProvider dummyProvider() {
        return new DummyProvider("dummy provider");
    }

    @Bean
    @ConditionalOnResource(resources = {"classpath:conditional-on-property/app.properties",
            "classpath:conditional-on-property/non-existenapp.properties"})
    DummyGenerator dummyGenerator() {
        return new DummyGenerator("never created");
    }

}
