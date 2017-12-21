package cn.ralken.aspectj.internal;

/**
 * Default implementation class that does nothing.
 * <p>
 * Created by Ralken Liao
 */

public class VoidInterceptor implements Interceptor {

    @Override
    public boolean intercept() {
        return false;
    }

    @Override
    public boolean onActionIntercepted() {
        return false;
    }
}
