package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        int del = 1;
        for (int i = 0; i < num.length(); i++) {
            int digit = Integer.parseInt(num) / del % 10;
            if (digit % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            del *= 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
