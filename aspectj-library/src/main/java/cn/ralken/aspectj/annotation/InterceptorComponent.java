package cn.ralken.aspectj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Predicates a class is interceptor component, the instance is created and maintained as singleton by Carver.
 * <br>
 * Generally, you should not initialize this class manually.
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface InterceptorComponent {
}
