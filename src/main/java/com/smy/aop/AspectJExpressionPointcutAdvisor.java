package com.smy.aop;

import org.aopalliance.aop.Advice;

/**
 * Created by shaomy on 2019/10/25/025.
 */
public class AspectJExpressionPointcutAdvisor implements PointCutAdvisor {
    private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

    private Advice advice;

    private String expression;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public PointCut getPointcut() {
        return pointcut;
    }
}
