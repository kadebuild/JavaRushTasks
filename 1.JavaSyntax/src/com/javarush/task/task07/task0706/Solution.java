package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] household = new int[15];
        int even = 0, odd = 0;
        for (int i = 0; i < 15; i++) {
            household[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                even += household[i];
            } else {
                odd += household[i];
            }
        }
        if (even > odd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else if (even < odd) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
