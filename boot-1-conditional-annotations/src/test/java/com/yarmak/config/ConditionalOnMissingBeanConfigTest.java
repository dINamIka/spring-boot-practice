package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnMissingBeanConfig.class)
public class ConditionalOnMissingBeanConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testConditionalOnMissingBean_beanDoesntExist_shouldSucceed() {
        final DummyProvider dummyProvider = this.context.getBean(DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
        assertThat(dummyProvider.getServiceStatus()).isEqualTo("first dummy provider is initialized");
    }

    @Test
    public void testConditionalOnMissingBean_matchedBySpecifiedType_beanDoesntExist_shouldSucceed() {
        final DummyGenerator dummyGenerator = this.context.getBean(DummyGenerator.class);
        assertThat(dummyGenerator).isNotNull();
        assertThat(dummyGenerator.getServiceStatus()).isEqualTo("first dummy generator is initialized");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testConditionalOnMissingBean_beanExist_shouldFail() {
        this.context.getBean("neverCreatedDummyProvider", DummyProvider.class);
    }
}