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
@SpringBootTest(classes = ConditionalOnResourceConfig.class)
public class ConditionalOnResourceConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testCondtitionalOnResource_classpathRes_resourcePresent_shouldSucceed() {
        final DummyStorage dummyStorage = appContext.getBean(DummyStorage.class);
        assertThat(dummyStorage).isNotNull();
    }

    @Test
    public void testCondtitionalOnResource_absolutePath_resourcePresent_shouldSucceed() {
        final DummyProvider dummyProvider = appContext.getBean(DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testCondtitionalOnResource_classpathRes_resourceNotPresent_shouldFail() {
        appContext.getBean(DummyGenerator.class);
    }
}