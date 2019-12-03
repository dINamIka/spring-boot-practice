package com.yarmak.config;

import com.yarmak.service.DummyProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnJavaVersionConfig.class)
public class ConditionalOnJavaVersionConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testConditionalOnJavaVersion_java11_shouldSucceed() {
        final DummyProvider dummyProvider = this.context.getBean(DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
    }
}