package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int N = a.length;
        int countOfRectangle = 0;
        boolean option1;
        boolean option2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] == 1) {
                    if (i == N - 1) {
                        option1 = true;
                    } else if (a[i + 1][j] == 0) {
                        option1 = true;
                    } else {
                        option1 = false;
                    }
                    if (j == N - 1) {
                        option2 = true;
                    } else if (a[i][j + 1] == 0) {
                        option2 = true;
                    } else {
                        option2 = false;
                    }
                    if (option1 && option2) {
                        countOfRectangle++;
                    }
                }
            }
        }
        return countOfRectangle;
    }
}
