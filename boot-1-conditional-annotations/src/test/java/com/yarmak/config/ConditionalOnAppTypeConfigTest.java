package com.yarmak.config;

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
@SpringBootTest(classes = ConditionalOnAppTypeConfig.class)
public class ConditionalOnAppTypeConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testConditionalOnAppType_notWebApp_shouldSucceed() {
        final DummyStorage dummyStorage = this.appContext.getBean(DummyStorage.class);
        assertThat(dummyStorage).isNotNull();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testConditionalOnAppType_notWebApp_shouldFail() {
        this.appContext.getBean(DummyProvider.class);
    }
}