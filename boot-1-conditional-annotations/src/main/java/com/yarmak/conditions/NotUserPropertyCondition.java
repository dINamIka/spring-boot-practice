package com.yarmak.conditions;

import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.context.annotation.Conditional;

public class NotUserPropertyCondition extends NoneNestedConditions {

    public NotUserPropertyCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(UserPropertyCondition.class)
    static class OnUserProperty {}

}
