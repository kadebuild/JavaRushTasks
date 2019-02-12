package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        if (args[0].equals("-e"))
        {
            FileInputStream finStream = new FileInputStream(args[1]);
            FileOutputStream foutStream = new FileOutputStream(args[2]);
            byte[] byteArray = new byte[finStream.available()];
            byte[] byteArrayEncoded = new byte[finStream.available()];
            finStream.read(byteArray);
            for (int i = 0; i < byteArray.length; i++)
            {
                byteArrayEncoded[i] = (byte)(byteArray[i]+1);
            }
            foutStream.write(byteArrayEncoded);
            finStream.close();
            foutStream.close();
        }
        else if (args[0].equals("-d"))
        {
            FileInputStream finStream = new FileInputStream(args[1]);
            FileOutputStream foutStream = new FileOutputStream(args[2]);
            byte[] byteArray = new byte[finStream.available()];
            byte[] byteArrayDecoded = new byte[finStream.available()];
            finStream.read(byteArray);
            for (int i = 0; i < byteArray.length; i++)
            {
                byteArrayDecoded[i] = (byte)(byteArray[i]-1);
            }
            foutStream.write(byteArrayDecoded);
            finStream.close();
            foutStream.close();
        }
    }

}
