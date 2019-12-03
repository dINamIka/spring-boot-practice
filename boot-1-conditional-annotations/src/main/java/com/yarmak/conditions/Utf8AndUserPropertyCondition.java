package com.yarmak.conditions;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ConfigurationCondition;

public class Utf8AndUserPropertyCondition extends AllNestedConditions {

    public Utf8AndUserPropertyCondition() {
        super(ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(UserPropertyCondition.class)
    static class OnUserProperty {}

    @Conditional(UTF8EncryptionCondition.class)
    static class OnUtf8Encryption {}

}
