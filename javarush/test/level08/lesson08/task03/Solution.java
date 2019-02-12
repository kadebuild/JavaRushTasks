package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Иванов", "Иван");
        hashMap.put("Смирнов", "Иван");
        hashMap.put("Соболев", "Илья");
        hashMap.put("Петров", "Антон");
        hashMap.put("Саперов", "Алексей");
        hashMap.put("Новиков", "Иван");
        hashMap.put("Яковлев", "Анатолий");
        hashMap.put("Волков", "Артем");
        hashMap.put("Мешков", "Сергей");
        hashMap.put("Москвин", "Антон");

        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int numOfSame = 0;
        for (String str : map.values())
            if (str.contains(name))
                numOfSame++;
        return numOfSame;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int numOfSame = 0;
        for (String str : map.keySet())
            if (str.equals(lastName))
                numOfSame++;
        return numOfSame;
    }
}
