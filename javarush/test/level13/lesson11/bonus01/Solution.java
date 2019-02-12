package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fread = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        String lineOfFile;
        while ((lineOfFile = fread.readLine()) != null)
        {
            int num = Integer.parseInt(lineOfFile);
            if (num%2 == 0)
                evenNumbers.add(num);
        }
        for (int i = 0, n = evenNumbers.size(); i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
                if (evenNumbers.get(i) > evenNumbers.get(j))
                {
                    int buf = evenNumbers.get(i);
                    evenNumbers.set(i, evenNumbers.get(j));
                    evenNumbers.set(j, buf);
                }
            System.out.println(evenNumbers.get(i));
        }
    }
}
