package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        String file3 = reader.readLine();
        FileInputStream finStream = new FileInputStream(file1);
        FileOutputStream foutStream2 = new FileOutputStream(file2);
        FileOutputStream foutStream3 = new FileOutputStream(file3);

        int firstOutput = 0;
        int secondOutput = finStream.available()/2;
        if (finStream.available()%2 == 0)
            firstOutput = finStream.available() / 2;
        else
            firstOutput = finStream.available() / 2 + 1;
        byte[] bufByte = new byte[finStream.available()];

        finStream.read(bufByte);
        foutStream2.write(bufByte, 0, firstOutput);
        foutStream3.write(bufByte, firstOutput, secondOutput);

        reader.close();
        finStream.close();
        foutStream2.close();
        foutStream3.close();
    }
}
