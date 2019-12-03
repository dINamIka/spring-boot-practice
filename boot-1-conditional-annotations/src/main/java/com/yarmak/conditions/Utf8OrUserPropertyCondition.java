package com.yarmak.conditions;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class Utf8OrUserPropertyCondition extends AnyNestedCondition {

    public Utf8OrUserPropertyCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(UserPropertyCondition.class)
    static class OnUserProperty {}

    @Conditional(UTF8EncryptionCondition.class)
    static class OnUtf8Encryption {}

}
