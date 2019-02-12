package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream finStream = new FileInputStream(fileName1);
        FileOutputStream fouStream = new FileOutputStream(fileName2);

        int buf;
        int count = 1;
        while (true)
        {
            if (finStream.available() > 0)
            {
                buf = finStream.read();
                if (count % 2 == 0)
                    fouStream.write(buf);
                count++;
            }
            else
                break;
        }
        reader.close();
        finStream.close();
        fouStream.close();
    }
}
