package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Gendalf", new Date("JULY 1 1980"));
        map.put("Bred", new Date("AUGUST 1 1980"));
        map.put("Jolly", new Date("SEPTEMBER 1 1980"));
        map.put("Qwerty", new Date("OCTOBER 1 1980"));
        map.put("Asdfg", new Date("NOVEMBER 1 1980"));
        map.put("Privet", new Date("DECEMBER 1 1980"));
        map.put("Holy", new Date("JANUARY 1 1980"));
        map.put("Clone", new Date("FEBRUARY 1 1980"));
        map.put("Parker", new Date("MARCH 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> newMap = new HashMap<>(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            if (pair.getValue().getMonth() == 5 || pair.getValue().getMonth() == 6 || pair.getValue().getMonth() == 7)
                newMap.remove(pair.getKey());
        }
        map.clear();
        map.putAll(newMap);
    }
}
