package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream finStream = new FileInputStream(fileName);
        HashMap<Integer, Integer> mapOfByte = new HashMap<Integer, Integer>();
        int maxNumByte = 0;
        while (finStream.available() > 0)
        {
            int bufByte = finStream.read();
            int numOfByte = 1;
            if (mapOfByte.containsKey(bufByte))
            {
                numOfByte += mapOfByte.get(bufByte);
                if (maxNumByte < numOfByte)
                    maxNumByte = numOfByte;
            }
            mapOfByte.put(bufByte, numOfByte);
        }
        for (Map.Entry<Integer,Integer> pair : mapOfByte.entrySet())
        {
            if (pair.getValue() == maxNumByte)
                System.out.print(pair.getKey() + " ");
        }
        reader.close();
        finStream.close();
    }
}
