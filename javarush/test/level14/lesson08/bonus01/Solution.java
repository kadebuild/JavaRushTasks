package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileNotFoundException;
import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new NoSuchElementException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new IllegalClassFormatException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new InputMismatchException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new StringIndexOutOfBoundsException());
        exceptions.add(new FileNotFoundException());

    }
}
