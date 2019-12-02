package com.yarmak.config;

import com.yarmak.conditions.UserPropertyCondition;
import com.yarmak.service.DummyStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomSimpleConditionConfig {

    @Bean
    @Conditional(UserPropertyCondition.class)
    DummyStorage dummyStorage() {
        return new DummyStorage("dummy storage");
    }

}
