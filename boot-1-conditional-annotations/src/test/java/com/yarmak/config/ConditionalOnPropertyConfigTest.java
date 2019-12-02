package com.yarmak.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnPropertyConfig.class)
@TestPropertySource("classpath:conditional-on-property/app.properties")
public class ConditionalOnPropertyConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testCustomConfigStringBean_propertyIsTrue_shouldSucceed() {
        final String defaultStringBean = this.appContext.getBean("defaultStringBean", String.class);
        assertThat(defaultStringBean).isNotNull();
        assertThat(defaultStringBean).isEqualTo("here is my custom string bean");
    }

    @Test
    public void testAdditionalBeanInitWithConditionOnMethod_propertyIsTrue_shouldSucceed() {
        final String addStringBean = this.appContext.getBean("firstAdditionalStringBean", String.class);
        assertThat(addStringBean).isNotNull();
        assertThat(addStringBean).isEqualTo("here is my first additional custom string bean");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testAdditionalBeanWithConditionOnMethod_propertyIsFalse_shouldFail() {
        this.appContext.getBean("secondAdditionalStringBean", String.class);
    }
}