package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number1String = reader.readLine();
        int number1 = Integer.parseInt(number1String);
        String number2String = reader.readLine();
        int number2 = Integer.parseInt(number2String);
        String number3String = reader.readLine();
        int number3 = Integer.parseInt(number3String);
        if (number1 == number2 && number2 == number3)
            System.out.println(number1 + " " + number2 + " " + number3);
        else if (number1 == number2)
            System.out.println(number1 + " " + number2);
        else if (number2 == number3)
            System.out.println(number2 + " " + number3);
        else if (number1 == number3)
            System.out.println(number1 + " " + number3);
    }
}