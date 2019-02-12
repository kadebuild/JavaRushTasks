package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        String buf;
        while ((buf = fileReader.readLine()) != null)
        {
            String[] strArray = buf.split(" ");
            for (int i = 0; i < strArray.length; i++)
            {
                try
                {
                    Integer.parseInt(strArray[i]);
                    fileWriter.write(strArray[i] + " ");
                }
                catch (NumberFormatException e) {}
            }
        }
        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}
