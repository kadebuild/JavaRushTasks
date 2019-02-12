package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        ReadThread readThread;
        while (!(file = reader.readLine()).equals("exit"))
        {
            readThread = new ReadThread(file);
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws IOException
        {
            this.fileName = fileName;
            fileReading();
        }

        @Override
        public void run()
        {}

        public void fileReading() throws IOException
        {
            HashMap<Integer, Integer> hashMapByte = new HashMap<Integer, Integer>();
            int numOfMaxByte = 0;
            int maxByte = 0;
            FileInputStream finStream = new FileInputStream(this.fileName);
            while (finStream.available() > 0)
            {
                int bufByte = finStream.read();
                int num = 1;
                if (hashMapByte.containsKey(bufByte))
                {
                    num += hashMapByte.get(bufByte);
                    hashMapByte.put(bufByte, num);
                }
                else
                    hashMapByte.put(bufByte, 1);
                if (numOfMaxByte < num)
                {
                    numOfMaxByte = num;
                    maxByte = bufByte;
                }
            }
            resultMap.put(this.fileName, maxByte);
            finStream.close();
        }
    }
}
