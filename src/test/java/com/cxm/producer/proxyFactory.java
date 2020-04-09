package com.cxm.producer;

import java.lang.reflect.Proxy;

/**
 * 动态代理工厂类
 */
public class proxyFactory {
    public static Object getproxy(Object o){
        dongtaiproxyClass dpc = new dongtaiproxyClass(o);
        Object proxy= Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),dpc);
        return proxy;
    }
}
