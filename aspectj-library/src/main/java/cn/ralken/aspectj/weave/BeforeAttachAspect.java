package cn.ralken.aspectj.weave;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import cn.ralken.aspectj.annotation.BeforeAttach;
import cn.ralken.aspectj.internal.ComponentFactory;
import cn.ralken.aspectj.internal.MethodInterceptor;

/**
 * Created by Ralken Liao
 */

@Aspect
public class BeforeAttachAspect {
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

        BeforeAttach attachPoint = methodSignature.getMethod().getAnnotation(BeforeAttach.class);
        Class<? extends MethodInterceptor> clz = attachPoint.interceptor();
        MethodInterceptor instance = ComponentFactory.createSingle(clz);

        switch (attachPoint.mode()) {
            case MODE_METHOD_END:
                Object result = joinPoint.proceed();
                if (instance.intercept()) {
                    instance.onActionIntercepted();
                }
                return result;
            case MODE_METHOD_START:
            default:
                boolean intercept = instance.intercept();
                if (!intercept || instance.onActionIntercepted()) {
                    return joinPoint.proceed();
                }
                return null;
        }

    }

}
