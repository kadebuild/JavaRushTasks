package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream finStream = new FileInputStream(args[0]);
        int numOfAllChar = finStream.available();
        int numOfSpaceChar = 0;
        while (finStream.available() > 0)
        {
            int curByte = finStream.read();
            if (curByte == 32)
                numOfSpaceChar++;
        }
        double result = (numOfSpaceChar*1d)/numOfAllChar*100;
        result = new BigDecimal(result).setScale(2, RoundingMode.FLOOR).doubleValue();
        System.out.println(result);
        finStream.close();
    }
}
