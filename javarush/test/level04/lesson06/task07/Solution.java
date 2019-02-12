package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1String = reader.readLine();
        int num1 = Integer.parseInt(num1String);
        String num2String = reader.readLine();
        int num2 = Integer.parseInt(num2String);
        String num3String = reader.readLine();
        int num3 = Integer.parseInt(num3String);
        if (num1 != num2 && num1 != num3)
            System.out.println("1");
        else if (num2 != num1 && num2 != num3)
            System.out.println("2");
        else
            System.out.println("3");
    }
}
