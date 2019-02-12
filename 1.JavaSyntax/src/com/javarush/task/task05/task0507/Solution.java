package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception { // Начало программы
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int digit;
        int numOfDigits = 0;
        float sredAriphmet = 0;
        while ((digit = Integer.parseInt(reader.readLine())) != -1) {
            sredAriphmet += digit;
            numOfDigits++;
        }
        if (numOfDigits > 0) {
            sredAriphmet /= numOfDigits;
        }
        System.out.println(sredAriphmet);
    }
}

