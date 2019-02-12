package com.javarush.task.task22.task2210;

import java.util.*;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        List<String> stringList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            stringList.add(stringTokenizer.nextToken());
        }
        String[] strings = new String[stringList.size()];
        strings = stringList.toArray(strings);
        return strings;
    }
}
