package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("мама");
        stringList.add("мыла");
        stringList.add("раму");
        stringList.add(1, "именно");
        stringList.add(3, "именно");
        stringList.add("именно");

        for (int i = 0; i < stringList.size(); i++)
            System.out.println(stringList.get(i));
    }
}
