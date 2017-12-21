package cn.ralken.android.sample;

import cn.ralken.aspectj.internal.Interceptor;

/**
 * Created by Ralken Liao
 */

public class LoginInterceptor implements Interceptor {

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
