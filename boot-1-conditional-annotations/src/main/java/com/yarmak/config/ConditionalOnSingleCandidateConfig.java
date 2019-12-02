package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnSingleCandidateConfig {

    @Bean
    DummyProvider dummyProvider() {
        return new DummyProvider("dummy provider");
    }

    @Bean
    @ConditionalOnSingleCandidate(DummyProvider.class)
    DummyProvider additionalDummyProvider() {
        return new DummyProvider("additional dummy provider");
    }

    @Bean
    @ConditionalOnSingleCandidate(DummyProvider.class)
    DummyGenerator dummyGenerator() {
        return new DummyGenerator("never created generator");
    }
}
