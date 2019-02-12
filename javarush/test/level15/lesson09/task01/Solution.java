package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }

    static
    {
        labels.put(5d, "5d");
        labels.put(7d, "7d");
        labels.put(6d, "6d");
        labels.put(8d, "8d");
        labels.put(50d, "50d");
    }
}
