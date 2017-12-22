package cn.ralken.aspectj.internal;

/**
 * Created by Ralken Liao on 21/12/2017.
 */

public interface MethodInterceptor {

    /**
     * Provide the condition that tells Carver when it should work.
     *
     * @return if true, the target method execution would been stopped and error scenario will be dispatched.
     */
    boolean intercept();

    /**
     * Called when the target method been intercepted. Generally you should handle further actions here.
     *
     * @return true if handle actions on your own.
     */
    boolean onActionIntercepted();

}
