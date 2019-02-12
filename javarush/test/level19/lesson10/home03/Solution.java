package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        String buf;
        while ((buf = fileReader.readLine()) != null)
        {
            String[] personArray = buf.split(" ");
            String name = "";
            int day = Integer.parseInt(personArray[personArray.length-3]);
            int month = Integer.parseInt(personArray[personArray.length-2]);
            int year = Integer.parseInt(personArray[personArray.length-1]);
            for (int i = 0; i < personArray.length-3; i++)
            {
                if (i != personArray.length-4)
                    name += personArray[i] + " ";
                else
                    name += personArray[i];
            }
            PEOPLE.add(new Person(name, new Date(year-1900, month-1, day)));
        }
        fileReader.close();
    }

}
