package com.yarmak.config;

import com.yarmak.conditions.ConditionalOnUTF8Encryption;
import com.yarmak.conditions.NotUserPropertyCondition;
import com.yarmak.conditions.Utf8AndUserPropertyCondition;
import com.yarmak.conditions.Utf8OrUserPropertyCondition;
import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnCustomMultiConditionsConfig {

    @Bean
    @Conditional(Utf8OrUserPropertyCondition.class)
    DummyProvider dummyProvider() {
        return new DummyProvider("new provider");
    }

    @Bean
    @Conditional(Utf8AndUserPropertyCondition.class)
    DummyGenerator dummyGenerator() {
        return new DummyGenerator("never existed generator");
    }

    @Bean
    @Conditional(NotUserPropertyCondition.class)
    DummyStorage dummyStorage() {
        return new DummyStorage("dummy storage");
    }

    @Bean
    @Conditional(NotUserPropertyCondition.class)
    @ConditionalOnClass
    DummyStorage multiConditionallyCreatedDummyStorage() {
        return new DummyStorage("custom dummy storage");
    }

    @Bean
    @ConditionalOnUTF8Encryption
    DummyGenerator generatorCreatedWithCustomConditionalAnnotation() {
        return new DummyGenerator("custom generator");
    }

}
