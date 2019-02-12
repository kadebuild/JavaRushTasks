package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws Exception {
        Integer i = 10;
        Object o = i;
        System.out.println((String) o);
    }

    public void methodThrowsNullPointerException() {
        Integer x = null;
        System.out.println(x.toString());
    }

    public static void main(String[] args) {

    }
}
