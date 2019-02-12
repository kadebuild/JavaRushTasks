package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener) {
        String[] strings = new String[3];
        Long[] ids = new Long[3];
        strings[0] = "Privet my name is";
        strings[1] = "Hello this is MyKomarik";
        strings[2] = "Privet my name is";
        for (int i = 0; i < 3; i++) {
            ids[i] = shortener.getId(strings[i]);
        }
        Assert.assertNotEquals(ids[1], ids[0]);
        Assert.assertNotEquals(ids[1], ids[2]);
        Assert.assertEquals(ids[0],ids[2]);
        for (int i = 0; i < 3; i++) {
            String bufferString = shortener.getString(ids[i]);
            Assert.assertEquals(bufferString, strings[i]);
        }
    }
    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy storageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy() {
        OurHashMapStorageStrategy storageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy() {
        FileStorageStrategy storageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy() {
        HashBiMapStorageStrategy storageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy() {
        DualHashBidiMapStorageStrategy storageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy() {
        OurHashBiMapStorageStrategy storageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(storageStrategy);
        testStorage(shortener);
    }
}
