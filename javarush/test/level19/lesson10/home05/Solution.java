package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String buf;
        while ((buf = fileReader.readLine()) != null)
        {
            String[] arrayOfWords = buf.split(" ");
            for (int i = 0; i < arrayOfWords.length; i++)
            {
                for (int j = 0; j < 10; j++)
                    if (arrayOfWords[i].contains(""+j))
                    {
                        fileWriter.write(arrayOfWords[i] + " ");
                        break;
                    }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
