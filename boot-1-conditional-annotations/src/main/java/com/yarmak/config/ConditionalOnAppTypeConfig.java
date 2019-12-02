package com.yarmak.config;

import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnAppTypeConfig {

    @Bean
    @ConditionalOnNotWebApplication
    DummyStorage dummyStorage() {
        return new DummyStorage("dummy storage");
    }

    @Bean
    @ConditionalOnWebApplication
    DummyProvider dummyProvider() {
        return new DummyProvider("not existed bean");
    }
}
