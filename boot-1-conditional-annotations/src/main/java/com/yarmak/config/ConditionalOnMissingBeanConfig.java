package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnMissingBeanConfig {

    @Bean
    @ConditionalOnMissingBean
    DummyProvider dummyProvider() {
        return new DummyProvider("first dummy provider");
    }

    @Bean
    @ConditionalOnMissingBean(DummyGenerator.class)
    DummyGenerator dummyGenerator() {
        return new DummyGenerator("first dummy generator");
    }

    @Bean
    @ConditionalOnMissingBean(DummyProvider.class)
    DummyProvider neverCreatedDummyProvider() {
        return new DummyProvider("never existed");
    }

}
