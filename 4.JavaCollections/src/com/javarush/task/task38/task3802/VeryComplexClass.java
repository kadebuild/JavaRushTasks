package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.text.SimpleDateFormat;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        final String string = "1";
        System.out.println(new SimpleDateFormat("dd.MM.yyyy").parse(string));
    }

    public static void main(String[] args) {
        try {
            new VeryComplexClass().veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
