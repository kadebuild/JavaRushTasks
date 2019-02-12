package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());
        int maxDelitel = 1;
        for (int i = 2; i <= (num1 < num2 ? num1 : num2); i++)
        {
            if (num1%i == 0 && num2%i == 0)
                maxDelitel = i;
        }
        System.out.println(maxDelitel);
    }
}
