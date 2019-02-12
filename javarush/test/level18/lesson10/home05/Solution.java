package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fReader = new FileInputStream(file1);
        FileOutputStream fWriter = new FileOutputStream(file2);
        String bufNum = "";
        while (fReader.available() > 0)
        {
            int byteCode = fReader.read();
            if (byteCode != 32 && fReader.available() != 0)
            {
                bufNum += (char)byteCode;
            }
            else
            {
                if (fReader.available() == 0 && byteCode != 32)
                    bufNum += (char)byteCode;
                String res = "" + Math.round(Double.parseDouble(bufNum));
                for (int i = 0; i < res.length(); i++)
                    fWriter.write(res.codePointAt(i));
                fWriter.write(32);
                bufNum = "";
            }
        }
        reader.close();
        fReader.close();
        fWriter.close();
    }
}
