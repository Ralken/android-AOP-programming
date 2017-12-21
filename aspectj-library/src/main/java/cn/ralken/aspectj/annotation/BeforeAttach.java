package cn.ralken.aspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.ralken.aspectj.internal.Interceptor;
import cn.ralken.aspectj.internal.VoidInterceptor;
import cn.ralken.aspectj.internal.VoidThrowable;

/**
 * Created by Ralken Liao
 */

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface BeforeAttach {
    /**
     * Data type inside an annotation must be one of
     * byte,short,char,int,long,float,double,boolean and String,Enum,Class,annotations.
     */
    Class<? extends Interceptor> interceptor()
            default VoidInterceptor.class;

    Class<? extends Throwable> thrown()
            default VoidThrowable.class;
}
