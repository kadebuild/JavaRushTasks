package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        String buf;
        double max = 0;
        while ((buf = fileReader.readLine()) != null)
        {
            String[] arr = buf.split(" ");
            if (hashMap.containsKey(arr[0]))
            {
                hashMap.put(arr[0], (hashMap.get(arr[0]) + Double.parseDouble(arr[1])));
                if (max < hashMap.get(arr[0]))
                    max = hashMap.get(arr[0]);
            }
            else
            {
                hashMap.put(arr[0], Double.parseDouble(arr[1]));
                if (max < Double.parseDouble(arr[1]))
                    max = Double.parseDouble(arr[1]);
            }
        }
        for (Map.Entry<String, Double> pair : hashMap.entrySet())
        {
            if (pair.getValue() == max)
                System.out.println(pair.getKey());
        }
        fileReader.close();
    }
}
