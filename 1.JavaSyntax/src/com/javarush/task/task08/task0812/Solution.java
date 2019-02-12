package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers = new ArrayList<>(10);
        int maxRunningInt = 1;
        int currentRunningInt = 1;
        numbers.add(Integer.parseInt(reader.readLine()));
        int currentRunningNumInt = numbers.get(0);
        for (int i = 1; i < 10; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
            if (currentRunningNumInt == numbers.get(i)) {
                currentRunningInt++;
            } else {
                currentRunningNumInt = numbers.get(i);
                currentRunningInt = 1;
            }
            if (maxRunningInt < currentRunningInt) {
                maxRunningInt = currentRunningInt;
            }
        }
        System.out.println(maxRunningInt);
    }
}