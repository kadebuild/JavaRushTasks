package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++)
            stringList.add(reader.readLine());
        int maxSize = 0;
        for (int i = 0; i < 5; i++)
        {
            if (maxSize < stringList.get(i).length())
                maxSize = stringList.get(i).length();
        }

        for (int i = 0; i < 5; i++)
            if (stringList.get(i).length() == maxSize)
                System.out.println(stringList.get(i));
    }
}
