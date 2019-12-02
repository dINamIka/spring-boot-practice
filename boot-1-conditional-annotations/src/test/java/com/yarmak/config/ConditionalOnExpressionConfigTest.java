package com.yarmak.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnExpressionConfig.class)
@TestPropertySource("classpath:conditional-on-expression/app.properties")
public class ConditionalOnExpressionConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testConditionalOnExpressionOnClass_checkPropertyValue_propertyMatches_shouldSucceed() {
        final String stringBeanA = this.context.getBean("stringBeanA", String.class);
        assertThat(stringBeanA).isNotNull();
        assertThat(stringBeanA).isEqualTo("stringBeanA");
    }

    @Test
    public void testConditionalOnExpression_onMethod_checkPropertyValue_propertyMatches_shouldSucceed() {
        final String stringBeanB = this.context.getBean("stringBeanB", String.class);
        assertThat(stringBeanB).isNotNull();
        assertThat(stringBeanB).isEqualTo("stringBeanB");
    }

    @Test
    public void testConditionalOnExpression_onMethod_multipleValues_checkPropertyValue_propertyMatches_shouldSucceed() {
        final String stringBeanC = this.context.getBean("stringBeanC", String.class);
        assertThat(stringBeanC).isNotNull();
        assertThat(stringBeanC).isEqualTo("stringBeanC");
    }
}