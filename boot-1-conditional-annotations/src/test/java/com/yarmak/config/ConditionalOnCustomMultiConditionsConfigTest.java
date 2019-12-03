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
@SpringBootTest(classes = ConditionalOnCustomMultiConditionsConfig.class)
public class ConditionalOnCustomMultiConditionsConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testCustomORConditional_shouldSucceed() {
        final DummyProvider dummyProvider = this.context.getBean(DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testCustomAndConditional_shouldSucceed() {
        this.context.getBean("dummyGenerator", DummyGenerator.class);
    }

    @Test
    public void testCustomNotConditional_shouldSucceed() {
        final DummyStorage dummyStorage = this.context.getBean("dummyStorage", DummyStorage.class);
        assertThat(dummyStorage).isNotNull();
    }

    @Test
    public void testMulgeneratorCreatedWithCustomConditionalAnnotationtiAnnotationalAndCondition_shouldSucceed() {
        final DummyStorage dummyStorage = this.context.getBean("multiConditionallyCreatedDummyStorage", DummyStorage.class);
        assertThat(dummyStorage).isNotNull();
    }

    @Test
    public void testCustomUTF8ConditionalAnnotation_shouldSucceed() {
        final DummyGenerator dummyGenerator = this.context.getBean("generatorCreatedWithCustomConditionalAnnotation", DummyGenerator.class);
        assertThat(dummyGenerator).isNotNull();
    }
}