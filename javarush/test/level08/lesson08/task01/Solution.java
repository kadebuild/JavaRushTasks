package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> stringSet = new HashSet<>();
        stringSet.add("Лама");
        stringSet.add("Лаборатория");
        stringSet.add("Лажа");
        stringSet.add("Лаванда");
        stringSet.add("Лук");
        stringSet.add("Лич");
        stringSet.add("Личина");
        stringSet.add("Личинка");
        stringSet.add("Лава");
        stringSet.add("Лоо");
        stringSet.add("Локомотив");
        stringSet.add("Лол");
        stringSet.add("Леша");
        stringSet.add("Лекция");
        stringSet.add("Лустрация");
        stringSet.add("Лубрикант");
        stringSet.add("Летиция");
        stringSet.add("Лот");
        stringSet.add("Лаустрафобия");
        stringSet.add("Лень");
        return stringSet;
    }
}
