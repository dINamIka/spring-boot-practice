package com.yarmak.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${custom.config.enabled}")
public class ConditionalOnExpressionConfig {

    @Bean
    String stringBeanA() {
        return "stringBeanA";
    }

    @Bean
    @ConditionalOnExpression("${first.additional.bean.enabled}")
    String stringBeanB() {
        return "stringBeanB";
    }

    //value after colon means default value of the property
    @Bean
    @ConditionalOnExpression("${first.additional.bean.enabled} and !${second.additional.bean.enabled:false}")
    String stringBeanC() {
        return "stringBeanC";
    }

}
