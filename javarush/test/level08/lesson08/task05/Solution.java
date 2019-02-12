package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("Новак", "Клара");
        hashMap.put("Буличев", "Карл");
        hashMap.put("Короч", "Клара");
        hashMap.put("Легков", "Петр");
        hashMap.put("Лермонтов", "Саша");
        hashMap.put("Давидов", "Давид");
        hashMap.put("Интерес", "Саша");
        hashMap.put("Трушникова", "Клара");
        hashMap.put("Бреш", "Петр");
        hashMap.put("Словин", "Слава");

        return hashMap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        String nameDuplicate = "";
        map.values();
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            int numOfDup = 0;
            for (Map.Entry<String, String> pair2: copy.entrySet())
            {
                if (pair.getValue().equals(pair2.getValue()) && !pair.getKey().equals(pair2.getKey()))
                {
                    map.remove(pair2.getKey());
                    numOfDup++;
                }
            }
            if (numOfDup > 0)
                map.remove(pair.getKey());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
