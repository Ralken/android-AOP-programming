package cn.ralken.aspectj.weave;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import cn.ralken.aspectj.annotation.BeforeAttach;
import cn.ralken.aspectj.internal.Interceptor;
import cn.ralken.aspectj.internal.VoidThrowable;

/**
 * Created by Ralken Liao
 */

@Aspect
public class AttachAnalysisPointAspect {
    private static final String POINTCUT_METHOD =
            "execution(@cn.ralken.aspectj.annotation.BeforeAttach * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@cn.ralken.aspectj.annotation.BeforeAttach *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        BeforeAttach before = methodSignature.getMethod().getAnnotation(BeforeAttach.class);

        Class<? extends Interceptor> value = before.interceptor();
        Interceptor instance = value.newInstance();
        boolean intercept = instance.intercept();

        if (!intercept) {
            return joinPoint.proceed();
        }

        if (before.thrown() != VoidThrowable.class) {
            throw before.thrown().newInstance();
        }

        return null;
    }
}
