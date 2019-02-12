package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream finStream = new FileInputStream(fileName);
        int numOfZapyataya = 0;
        while (finStream.available() > 0)
        {
            int bufByte = finStream.read();
            if (bufByte == 44)
                numOfZapyataya++;
        }
        System.out.println(numOfZapyataya);
        reader.close();
        finStream.close();
    }
}
