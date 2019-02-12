package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fStream = new FileInputStream(fileName);
        int minByte = fStream.read();
        while (fStream.available() > 0)
        {
            int buf = fStream.read();
            if (minByte > buf)
                minByte = buf;
        }
        System.out.println(minByte);
        reader.close();
        fStream.close();
    }
}
