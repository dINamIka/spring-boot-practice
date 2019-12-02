package com.yarmak.config;

import com.yarmak.service.DummyGenerator;
import com.yarmak.service.DummyProvider;
import com.yarmak.service.DummyStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConditionalOnPropertyConfig.class, ConditionalOnBeanConfig.class})
@TestPropertySource(locations = "classpath:conditional-on-property/app.properties")
public class ConditionalOnBeanConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testConditionalOnBean_matchByClass_conditionalPresent_shouldSucceed() {
        final DummyProvider dummyProvider = this.appContext.getBean("dummyProvider", DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
        assertThat(dummyProvider.getServiceStatus()).isEqualTo("dummy provider is initialized");
    }

    @Test
    public void testConditionalOnBean_matchByClassAndBeanName_conditionalPresent_shouldSucceed() {
        final DummyStorage dummyStorage = this.appContext.getBean(DummyStorage.class);
        assertThat(dummyStorage).isNotNull();
        assertThat(dummyStorage.getServiceStatus()).isEqualTo("dummy storage is initialized");
    }

    @Test
    public void testConditionalOnBean_matchByClassOrBeanName_conditionalPresent_shouldSucceed() {
        final DummyGenerator dummyGenerator = this.appContext.getBean(DummyGenerator.class);
        assertThat(dummyGenerator).isNotNull();
        assertThat(dummyGenerator.getServiceStatus()).isEqualTo("dummy generator is initialized");
    }

    @Test
    public void testConditionalOnBean_matchByFactoryMethodReturnType_conditionalPresent_shouldSucceed() {
        final DummyProvider dummyProvider = this.appContext.getBean("customDummyProvider", DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
        assertThat(dummyProvider.getServiceStatus()).isEqualTo("custom dummy provider is initialized");
    }
}