package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1String = reader.readLine();
        int num1 = Integer.parseInt(num1String);
        String num2String = reader.readLine();
        int num2 = Integer.parseInt(num2String);
        String num3String = reader.readLine();
        int num3 = Integer.parseInt(num3String);
        if ((num1 < num2 && num1 > num3) || (num1 > num2 && num1 < num3))
            System.out.println(num1);
        else if ((num2 < num1 && num2 > num3) || (num2 > num1 && num2 < num3))
            System.out.println(num2);
        else
            System.out.println(num3);
    }
}
