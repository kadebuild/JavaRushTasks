package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods original;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object result = method.invoke(original, args);
        System.out.println(method.getName() + " out");
        return result;
    }
    public CustomInvocationHandler(SomeInterfaceWithMethods s) {
        this.original = s;
    }
}
