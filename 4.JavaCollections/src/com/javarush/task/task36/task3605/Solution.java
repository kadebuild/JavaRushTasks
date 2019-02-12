package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] file = Files.readAllBytes(Paths.get(args[0]));
        Set<Character> treeset = new TreeSet<>();
        for (byte symbol : file) {
            if (symbol >= 65 && symbol <= 90) {
                treeset.add((char)(symbol+32));
            } else if (symbol >= 97 && symbol <= 122) {
                treeset.add((char)symbol);
            }
        }
        int num = 5;
        for (Character c : treeset) {
            System.out.print(c);
            num--;
            if (num == 0) {
                break;
            }
        }
    }
}
