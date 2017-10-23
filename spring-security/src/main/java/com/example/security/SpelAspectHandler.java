package com.example.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SpelAspectHandler {

    @Before(value = "@annotation(authorizationFilter)")
    public Object authorize(AuthorizationFilter authorizationFilter) throws RuntimeException {
        String expressionContent = authorizationFilter.value();
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(expressionContent);

        try {
            //TODO: configure evaluation context
            return expression.getValue(new StandardEvaluationContext());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
