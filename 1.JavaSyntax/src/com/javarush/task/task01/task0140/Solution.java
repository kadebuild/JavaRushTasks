package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        Scanner scaner = new Scanner(System.in);
        a = scaner.nextInt();
        a *= a;
        System.out.println(a);
    }
} 