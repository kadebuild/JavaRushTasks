package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream finStream1 = new FileInputStream(file1);
        FileInputStream finStream2 = new FileInputStream(file2);
        byte[] bufByteFile1 = new byte[finStream1.available()];
        byte[] bufByteFile2 = new byte[finStream2.available()];
        int countFile1 = finStream1.read(bufByteFile1);
        int countFile2 = finStream2.read(bufByteFile2);
        finStream1.close();
        FileOutputStream foutStream = new FileOutputStream(file1);
        foutStream.write(bufByteFile2, 0, countFile2);
        foutStream.write(bufByteFile1, 0, countFile1);
        foutStream.close();
        finStream2.close();
        reader.close();
    }
}
