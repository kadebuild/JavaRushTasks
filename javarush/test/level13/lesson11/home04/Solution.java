package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileWriter writer = new FileWriter(fileName);
        while (true)
        {
            String strToFile = reader.readLine();
            if (strToFile.equals("exit"))
            {
                writer.write(strToFile);
                break;
            }
            writer.write(strToFile + "\n");
        }
        reader.close();
        writer.close();
    }
}
