package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnClassConfig {

    @Bean
    @ConditionalOnClass(name = "org.slf4j.Logger")
    DummyStorage defaultDummyStorage() {
        //will be created as Logger is present
        return new DummyStorage("dummy storage");
    }

    @Bean
    @ConditionalOnClass(name = "com.yarmak.NonExistentClass")
    DummyGenerator defaultDummyGenerator() {
        //won't be created as the specified class doesn't exist
        return new DummyGenerator("dummy generator");
    }

    @Bean
    @ConditionalOnMissingClass("org.slf4j.Logger")
    DummyStorage notCreatedDummyStorage() {
        //won't be created as Logger is already present
        return new DummyStorage("never existed dummy storage");
    }

    @Bean
    @ConditionalOnMissingClass("com.yarmak.NonExistentClass")
    DummyProvider dummyProvider() {
        //will be created as the specified class doesn't exist
        return new DummyProvider("dummy provider");
    }

}
