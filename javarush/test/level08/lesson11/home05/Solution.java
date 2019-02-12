package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] sArray;
        int newWord = 1;
        StringBuffer buf = new StringBuffer(s);
        String sBuf = "";
        for (int i = 0; i < s.length(); i++)
        {
            if ((int) s.charAt(i) == 32)
                newWord = 1;
            else if (newWord == 1)
            {
                sBuf = "" + s.charAt(i);
                buf.replace(i, i+1, sBuf.toUpperCase());
                newWord = 0;
            }
        }
        s = buf.substring(0);
        System.out.println(s);
    }


}
