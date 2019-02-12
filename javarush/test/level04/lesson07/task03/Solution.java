package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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
        int polozh = 0;
        if (num1 > 0)
            polozh++;
        if (num2 > 0)
            polozh++;
        if (num3 > 0)
            polozh++;
        System.out.println(polozh);
    }
}
