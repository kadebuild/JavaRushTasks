package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String w : words) {
                if (w.length() > 6) {
                    stringBuilder.append(w + ",");
                }
            }
        }
        fileWriter.write(stringBuilder.substring(0,stringBuilder.length()-1));
        fileReader.close();
        fileWriter.close();
    }
}
