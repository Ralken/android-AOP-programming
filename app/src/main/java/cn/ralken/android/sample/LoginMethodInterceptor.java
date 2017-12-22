package cn.ralken.android.sample;

import cn.ralken.aspectj.internal.MethodInterceptor;

/**
 * Created by Ralken Liao
 */

public class LoginMethodInterceptor implements MethodInterceptor {

    @Override
    public boolean intercept() {
        // TODO: 21/12/2017
        return true;
    }

    @Override
    public boolean onActionIntercepted() {
        return true;
    }
}
