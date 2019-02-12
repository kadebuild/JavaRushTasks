package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args[0].equals("-c"))
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName,true));
            String buf;
            int id = 0;
            while ((buf = fileReader.readLine()) != null)
            {
                int firstSpace = buf.indexOf(" ");
                if (firstSpace < 8 && firstSpace > 0)
                    buf = buf.substring(0,firstSpace);
                else
                    buf = buf.substring(0,8);
                if (id < Integer.parseInt(buf))
                    id = Integer.parseInt(buf);
            }
            String idString = "" + (id+1);
            StringBuffer strBuf = new StringBuffer("                                                  ");
            strBuf = spacingString(strBuf,idString,0);
            strBuf = spacingString(strBuf,args[1],8);
            strBuf = spacingString(strBuf,args[2],38);
            strBuf = spacingString(strBuf,args[3],46);
            fileReader.close();
            fileWriter.write(strBuf.toString());
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
