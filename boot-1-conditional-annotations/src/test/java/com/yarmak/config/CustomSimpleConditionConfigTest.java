package com.yarmak.config;

import com.yarmak.service.DummyStorage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomSimpleConditionConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomSimpleConditionConfigTest {

    static {
        System.setProperty("user.defined.property", "available");
    }


    @Autowired
    private ApplicationContext appContext;


    @Test
    public void testUserDefinedPropertyCondition_sysPropertySetUp_shouldSucceed() {
        final DummyStorage bean = this.appContext.getBean(DummyStorage.class);
        assertThat(bean).isNotNull();
    }

}