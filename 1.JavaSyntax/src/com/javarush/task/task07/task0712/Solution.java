package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int minSizeOfString = -1;
        int maxSizeOfString = 0;
        int minNumOfElem = 0;
        int maxNumOfElem = 0;
        for (int i = 0; i < 10; i++) {
            String buf = reader.readLine();
            list.add(buf);
            if (buf.length() < minSizeOfString || minSizeOfString == -1) {
                minSizeOfString = buf.length();
                minNumOfElem = i;
            }
            if (buf.length() > maxSizeOfString) {
                maxSizeOfString = buf.length();
                maxNumOfElem = i;
            }
        }
        if (minNumOfElem <= maxNumOfElem) {
            System.out.println(list.get(minNumOfElem));
        } else {
            System.out.println(list.get(maxNumOfElem));
        }
    }
}
