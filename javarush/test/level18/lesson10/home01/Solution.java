package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream finStream = new FileInputStream(args[0]);
        int numOfEngChar = 0;
        while (finStream.available() > 0)
        {
            int buf = finStream.read();
            if ((buf >= 65 && buf <= 90) || (buf >= 97 && buf <= 122))
                numOfEngChar++;
        }
        System.out.println(numOfEngChar);
        finStream.close();
    }
}
