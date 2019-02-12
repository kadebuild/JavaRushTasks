package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date date = new Date();
        for (String str : strings) {
            ids.add(shortener.getId(str));
        }
        return new Date().getTime() - date.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date date = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        return new Date().getTime() - date.getTime();
    }
    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> ids = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Long s1time = getTimeForGettingIds(shortener1, origStrings, ids);
        Long s2time = getTimeForGettingIds(shortener2, origStrings, ids);
        Assert.assertTrue(s1time > s2time);
        s1time = getTimeForGettingStrings(shortener1, ids, origStrings);
        s2time = getTimeForGettingStrings(shortener2, ids, origStrings);
        Assert.assertEquals(s1time, s2time, 30);
    }
}
