package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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
        if (num1 > num2 && num2 > num3)
            System.out.println(num1 + " " + num2 + " " + num3);
        else if (num1 > num3 && num3 > num2)
            System.out.println(num1 + " " + num3 + " " + num2);
        else if (num2 > num1 && num1 > num3)
            System.out.println(num2 + " " + num1 + " " + num3);
        else if (num2 > num3 && num3 > num1)
            System.out.println(num2 + " " + num3 + " " + num1);
        else if (num3 > num1 && num1 > num2)
            System.out.println(num3 + " " + num1 + " " + num2);
        else if (num3 > num2 && num2 > num1)
            System.out.println(num3 + " " + num2 + " " + num1);
    }
}
