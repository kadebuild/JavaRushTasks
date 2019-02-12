package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
            Class[] interfc = clazz.getInterfaces();
            if (List.class.isAssignableFrom(clazz) && Modifier.isPrivate(clazz.getModifiers()) && Modifier.isStatic(clazz.getModifiers())) {
                try {
                    final Constructor<?> constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    final List<?> list = (List<?>) constructor.newInstance();
                    list.get(0);
                } catch (final IndexOutOfBoundsException e) {
                    return clazz;
                } catch (final Exception ignored) {
                }
            }
        }
        return null;
    }
}
