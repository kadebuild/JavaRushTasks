package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        String filePath;

        ArrayList<String> listOfFilePaths = new ArrayList<String>();
        while(!(filePath = reader.readLine()).equals("end")){
            listOfFilePaths.add(filePath);
        }
        reader.close();

        Map<Integer, String> pairOfPartAndPath = new TreeMap<Integer, String>();

        for(String s : listOfFilePaths){
            String[] splitedPath = s.split(".part");

            String partPath = splitedPath[0];
            int partNum = Integer.parseInt(splitedPath[1]);

            pairOfPartAndPath.put(partNum, partPath);
        }

        String finalFile = listOfFilePaths.get(0).substring(0,listOfFilePaths.get(0).lastIndexOf("."));

        for(Map.Entry<Integer,String> m : pairOfPartAndPath.entrySet()){

            StringBuffer sb = new StringBuffer(".part");
            StringBuilder str = new StringBuilder(m.getValue() + sb + m.getKey());

            fis = new FileInputStream(str.toString());
            fos = new FileOutputStream(finalFile, true);

            byte[] buffer = new byte[fis.available()];
            while(fis.available() > 0){
                int count = fis.read(buffer);
                fos.write(buffer);
            }
            fis.close();
            fos.close();
        }
    }
}
