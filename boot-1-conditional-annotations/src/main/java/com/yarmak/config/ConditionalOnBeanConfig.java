package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalOnBeanConfig {

    @Bean
    @ConditionalOnBean(ConditionalOnPropertyConfig.class)
    DummyProvider dummyProvider() {
        return new DummyProvider("dummy provider");
    }

    @Bean
    @ConditionalOnBean(value = {String.class}, name = {"defaultStringBean"})
    DummyStorage dummyStorage() {
        return new DummyStorage("dummy storage");
    }


    //in this case spring checks if bean with specified class OR with specified name is present
    @Bean
    @ConditionalOnBean(value = {ConditionalOnPropertyConfig.class}, name = {"defaultStringBean"})
    DummyGenerator dummyGenerator() {
        return new DummyGenerator("dummy generator");
    }

    //if we don't specify type return type of the factory method is used
    @Bean
    @ConditionalOnBean
    DummyProvider customDummyProvider() {
        return new DummyProvider("custom dummy provider");
    }

}
