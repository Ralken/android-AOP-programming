package cn.ralken.aspectj.internal;

import java.util.WeakHashMap;

/**
 * Created by Ralken Liao on 22/12/2017.
 */

public class ComponentFactory {
    // TODO: 22/12/2017 Survey for context lifecycle scenario.
    private static WeakHashMap<Class<? extends MethodInterceptor>, MethodInterceptor> cacheProvider = new WeakHashMap<>();

    private ComponentFactory() {
    }

    public static MethodInterceptor createSingle(Class<? extends MethodInterceptor> clz) throws IllegalAccessException, InstantiationException {
        MethodInterceptor cache = cacheProvider.get(clz);
        if (cache == null) {
            cache = clz.newInstance();
            cacheProvider.put(clz, cache);
        }
        return cache;
    }
}
