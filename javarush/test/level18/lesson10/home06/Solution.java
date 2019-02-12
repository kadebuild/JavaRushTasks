package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream finStream = new FileInputStream(args[0]);
        HashMap<Integer, Integer> hashMapLetter = new HashMap<Integer, Integer>();
        while (finStream.available() > 0)
        {
            int bufByte = finStream.read();
            if (hashMapLetter.containsKey(bufByte))
            {
                int numOfLetter = hashMapLetter.get(bufByte) + 1;
                hashMapLetter.put(bufByte, numOfLetter);
            }
            else
                hashMapLetter.put(bufByte, 1);
        }
        TreeMap<Integer, Integer> treeMapLetter = new TreeMap<Integer, Integer>(hashMapLetter);
        for (Map.Entry<Integer, Integer> pair : treeMapLetter.entrySet())
            System.out.println((char)(int)pair.getKey() + " " + pair.getValue());
        finStream.close();
    }
}
