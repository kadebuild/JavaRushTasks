package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
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
        if (num1 < num2)
            System.out.println(num1);
        else
            System.out.println(num2);
    }
}