package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            for (String str : ((PrepareMyTest)c.getAnnotation(PrepareMyTest.class)).fullyQualifiedNames()) {
                System.out.println(str);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            for (Class str : ((PrepareMyTest)c.getAnnotation(PrepareMyTest.class)).value()) {
                System.out.println(str.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
