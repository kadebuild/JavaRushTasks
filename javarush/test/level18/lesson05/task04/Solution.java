package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream finStream = new FileInputStream(file1);
        FileOutputStream foutStream = new FileOutputStream(file2);

        byte[] bufByte = new byte[finStream.available()];
        finStream.read(bufByte);
        for (int i = bufByte.length-1; i >= 0; i--)
            foutStream.write(bufByte[i]);
        reader.close();
        finStream.close();
        foutStream.close();
    }
}
