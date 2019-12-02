package com.yarmak.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "custom.config.enabled", matchIfMissing = false, havingValue = "true")
public class ConditionalOnPropertyConfig {

    @Bean
    public String defaultStringBean() {
        return "here is my custom string bean";
    }


    @Bean
    @ConditionalOnProperty(value = "first.additional.bean.enabled", havingValue = "true")
    String firstAdditionalStringBean() {
        return "here is my first additional custom string bean";
    }


    @Bean
    @ConditionalOnProperty(value = "second.additional.bean.enabled", matchIfMissing = true, havingValue = "true")
    String secondAdditionalStringBean() {
        return "here is my second additional custom string bean";
    }
}
