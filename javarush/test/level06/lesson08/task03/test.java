package com.javarush.test.level06.lesson08.task03;

/**
 * Created by Admin on 03.01.2017.
 */
public class test
{
    public static double getDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(getDistance(x1,y1,x2,y2));
    }

    public static void main()
    {
        System.out.println(getDistance(1,1,5,5));
    }
}
