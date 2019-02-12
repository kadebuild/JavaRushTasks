package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> setId = new HashSet<>();
        for (String str : strings) {
            setId.add(shortener.getId(str));
        }
        return setId;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> setString = new HashSet<>();
        for (Long id : keys) {
            setString.add(shortener.getString(id));
        }
        return setString;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            strings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date time = new Date();
        Set<Long> setId = getIds(shortener, strings);
        long ms = new Date().getTime() - time.getTime();
        System.out.println("Время работы метода getIds: " + ms);
        time = new Date();
        Set<String> newStrings = getStrings(shortener, setId);
        ms = new Date().getTime() - time.getTime();
        System.out.println("Время работы метода getStrings: " + ms);
        if (strings.containsAll(newStrings) && strings.size() == newStrings.size()) {
            System.out.println("Тест пройден.");
        } else {
            System.out.println("Тест не пройден.");
        }
    }
}
