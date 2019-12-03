package com.yarmak.config;

import com.yarmak.service.DummyProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnJavaVersionConfig {

    @Bean
    @ConditionalOnJava(value = ConditionalOnJava.JavaVersion.NINE, range = ConditionalOnJava.Range.EQUAL_OR_NEWER)
    DummyProvider dummyProvider() {
        return new DummyProvider("dummy-provider");
    }

}
