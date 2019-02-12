package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileOutputStream foutStream1 = new FileOutputStream(file1);
        FileInputStream finStream2 = new FileInputStream(file2);
        FileInputStream finStream3 = new FileInputStream(file3);
        byte[] bufByte = new byte[finStream2.available()];
        int count = finStream2.read(bufByte);
        foutStream1.write(bufByte, 0, count);
        bufByte = new byte[finStream3.available()];
        count = finStream3.read(bufByte);
        foutStream1.write(bufByte, 0, count);
        reader.close();
        finStream2.close();
        finStream3.close();
        foutStream1.close();
    }
}
