package com.yarmak.conditions;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Example of simple custom condition that can be used in conjunction with
 */
public class UserPropertyCondition implements Condition {

    @Override
    public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
        return ("available".equals(System.getProperty("user.defined.property", "")));
    }

}
