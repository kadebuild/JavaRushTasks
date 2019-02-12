package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1Str = reader.readLine();
        int num1 = Integer.parseInt(num1Str);
        String num2Str = reader.readLine();
        int num2 = Integer.parseInt(num2Str);
        String num3Str = reader.readLine();
        int num3 = Integer.parseInt(num3Str);
        String num4Str = reader.readLine();
        int num4 = Integer.parseInt(num4Str);
        if (maxTwoNum(num1,num2) > maxTwoNum(num3,num4))
            System.out.println(maxTwoNum(num1,num2));
        else
            System.out.println(maxTwoNum(num3,num4));

    }

    public static int maxTwoNum(int a, int b)
    {
        if (a > b)
            return a;
        else
            return b;
    }

}
