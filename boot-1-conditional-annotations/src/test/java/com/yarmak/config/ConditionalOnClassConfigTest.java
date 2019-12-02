package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnClassConfig.class)
public class ConditionalOnClassConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testConditionalOnClass_classPresent_shouldSucceed() {
        final DummyStorage defaultDummyStorage = this.appContext.getBean("defaultDummyStorage", DummyStorage.class);
        assertThat(defaultDummyStorage).isNotNull();
        assertThat(defaultDummyStorage.getServiceStatus()).isEqualTo("dummy storage is initialized");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testConditionalOnClass_classNotPresent_shouldFail() {
        this.appContext.getBean(DummyGenerator.class);
    }

    @Test
    public void testConditionalOnMissingClass_classNotPresent_shouldSucceed() {
        final DummyProvider dummyProvider = this.appContext.getBean("dummyProvider", DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
        assertThat(dummyProvider.getServiceStatus()).isEqualTo("dummy provider is initialized");
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testConditionalOnMissingClass_classPresent_shouldFail() {
        this.appContext.getBean("notCreatedDummyStorage", DummyStorage.class);
    }
}