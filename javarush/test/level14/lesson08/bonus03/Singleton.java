package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private static Singleton instance;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if (!(instance instanceof Singleton))
            instance = new Singleton();
        return instance;
    }
}
