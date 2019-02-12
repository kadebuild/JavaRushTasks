package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
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
        int otric = 0;
        if (num1 > 0)
            polozh++;
        else if (num1 < 0)
            otric++;
        if (num2 > 0)
            polozh++;
        else if (num2 < 0)
            otric++;
        if (num3 > 0)
            polozh++;
        else if (num3 < 0)
            otric++;
        System.out.println("количество отрицательных чисел: " + otric);
        System.out.println("количество положительных чисел: " + polozh);
    }
}
