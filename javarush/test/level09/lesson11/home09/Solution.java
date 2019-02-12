package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> catMap = new HashMap<String, Cat>();

        catMap.put("Вася", new Cat("Вася"));
        catMap.put("Мурзик", new Cat("Мурзик"));
        catMap.put("Барсик", new Cat("Барсик"));
        catMap.put("Грация", new Cat("Грация"));
        catMap.put("Антонио", new Cat("Антонио"));
        catMap.put("Колян", new Cat("Колян"));
        catMap.put("Дошик", new Cat("Дошик"));
        catMap.put("Вольтер", new Cat("Вольтер"));
        catMap.put("Мадам", new Cat("Мадам"));
        catMap.put("Шкура", new Cat("Шкура"));

        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> catSet = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
            catSet.add(pair.getValue());
        return catSet;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
