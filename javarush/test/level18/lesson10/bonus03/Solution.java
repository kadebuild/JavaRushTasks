package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args[0].equals("-u"))
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> fileInfoArray = new ArrayList<String>();
            String buf;
            int index = -1;
            int i = 0;
            while ((buf = fileReader.readLine()) != null)
            {
                System.out.println("зашел в вайл");
                fileInfoArray.add(buf);
                System.out.println(buf);
                int firstSpace = buf.indexOf(" ");
                if (firstSpace < 8 && firstSpace > 0)
                    buf = buf.substring(0,firstSpace);
                else
                    buf = buf.substring(0,8);
                if (buf.equals(args[1]))
                {
                    index = i;
                    System.out.println(index);
                }
                i++;
            }
            StringBuffer strBuf = new StringBuffer("                                                  ");
            strBuf = spacingString(strBuf,args[1],0);
            strBuf = spacingString(strBuf,args[2],8);
            strBuf = spacingString(strBuf,args[3],38);
            strBuf = spacingString(strBuf,args[4],46);
            fileReader.close();
            if (index != -1)
                fileInfoArray.set(index,strBuf.toString());
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            fileWriter.write("");
            fileWriter.close();
            fileWriter = new BufferedWriter(new FileWriter(fileName,true));
            for (int j = 0, n = fileInfoArray.size(); j < n; j++)
            {
                fileWriter.write(fileInfoArray.get(j));
                fileWriter.newLine();
            }
            fileWriter.close();
        }
        else if (args[0].equals("-d"))
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            ArrayList<String> fileInfoArray = new ArrayList<String>();
            String buf;
            int index = -1;
            int i = 0;
            while ((buf = fileReader.readLine()) != null)
            {
                fileInfoArray.add(buf);
                int firstSpace = buf.indexOf(" ");
                if (firstSpace < 8 && firstSpace > 0)
                    buf = buf.substring(0,firstSpace);
                else
                    buf = buf.substring(0,8);
                if (buf.equals(args[1]))
                    index = i;
                i++;
            }
            fileReader.close();
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            fileWriter.write("");
            fileWriter.close();
            fileWriter = new BufferedWriter(new FileWriter(fileName,true));
            for (int j = 0, n = fileInfoArray.size(); j < n; j++)
            {
                if (j != index)
                {
                    fileWriter.write(fileInfoArray.get(j));
                    fileWriter.newLine();
                }
            }
            fileWriter.close();
        }
    }

    public static StringBuffer spacingString(StringBuffer strReplace, String strAddToBuf, int from)
    {
        for (int i = 0, n = strAddToBuf.length(); i < n; i++)
        {
            strReplace.replace(i+from,i+1+from,""+strAddToBuf.charAt(i));
        }
        return strReplace;
    }
}
