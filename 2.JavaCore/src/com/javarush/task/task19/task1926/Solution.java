package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            String buffer = fileReader.readLine();
            for (int i = buffer.length()-1; i >= 0; i--) {
                System.out.print(buffer.charAt(i));
            }
            System.out.println();
        }
        fileReader.close();
    }
}
