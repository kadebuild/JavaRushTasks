package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < 20; i++)
            integerHashSet.add(i);
        return integerHashSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        HashSet<Integer> newSet = new HashSet<>(set);
        for (Integer intik : set)
        {
            if (intik > 10)
                newSet.remove(intik);
        }
        return newSet;
    }
}
