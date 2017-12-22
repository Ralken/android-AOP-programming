package cn.ralken.aspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.ralken.aspectj.internal.MethodInterceptor;
import cn.ralken.aspectj.internal.VoidMethodInterceptor;

import static cn.ralken.aspectj.annotation.BeforeAttach.Mode.MODE_METHOD_START;

/**
 * An annotation which indicates that the  {@link MethodInterceptor} will
 * execute at the beginning of the annotated method.
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface BeforeAttach {

    enum Mode {
        MODE_METHOD_START, MODE_METHOD_END
    }

    /**
     * Data type inside an annotation must be one of
     * byte,short,char,int,long,float,double,boolean and String,Enum,Class,annotations.
     */
    Class<? extends MethodInterceptor> interceptor()
            default VoidMethodInterceptor.class;

    Mode mode()
            default MODE_METHOD_START;
}
