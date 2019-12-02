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

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConditionalOnSingleCandidateConfig.class)
public class ConditionalOnSingleCandidateConfigTest {

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void testConditionalOnSingleCandidate_conditionMatches_shouldSucceed() {
        final DummyProvider dummyProvider = this.appContext.getBean("additionalDummyProvider", DummyProvider.class);
        assertThat(dummyProvider).isNotNull();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testConditionalOnSingleCandidate_moreThanOneCandidate_shouldFail() {
        this.appContext.getBean(DummyGenerator.class);
    }
}