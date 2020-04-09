package com.cxm.producer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理实现类（动态代理不需要代理类实现接口）
 */
public class dongtaiproxyClass implements InvocationHandler {
    private Object target;

    public dongtaiproxyClass(Object o){
        this.target=o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        proxyStar1.method1();
        method.invoke(target,args);
        proxyStar1.method2();
        return null;
    }


    /**
     * 动态测试方法
     */
    public static void main(String args[]){
       Istar istar = new realStar();
//       Istar proxy=(Istar) proxyFactory.getproxy(istar);
//       proxy.Sing();
        Istar  proxy=(Istar) Proxy.newProxyInstance(istar.getClass().getClassLoader(),istar.getClass().getInterfaces(),new dongtaiproxyClass(istar));
        proxy.Sing();
    }
}
