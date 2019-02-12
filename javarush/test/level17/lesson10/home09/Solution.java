package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1;
        String file2;
        BufferedReader fileReader;
        String bufFile;
        try
        {
            file1 = reader.readLine();
            file2 = reader.readLine();
            fileReader = new BufferedReader(new FileReader(file1));
            while ((bufFile = fileReader.readLine()) != null)
                allLines.add(bufFile);
            fileReader = new BufferedReader(new FileReader(file2));
            while ((bufFile = fileReader.readLine()) != null)
                forRemoveLines.add(bufFile);
            reader.close();
            fileReader.close();
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
        try
        {
            new Solution().joinData();
        }
        catch (CorruptedDataException e)
        {}
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else
        {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
