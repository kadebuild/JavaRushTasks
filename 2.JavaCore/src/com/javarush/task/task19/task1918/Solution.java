package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> startTag = new ArrayList<>();
        ArrayList<Integer> endTag = new ArrayList<>();
        String buffer = "";
        while (fileReader.ready()) {
            buffer = buffer.concat(fileReader.readLine());
        }
        fileReader.close();
        startTag.add(buffer.indexOf("<" + args[0]));
        endTag.add(buffer.indexOf("</" + args[0]));
        while (buffer.indexOf("<" + args[0],startTag.get(startTag.size() - 1) + 1) != -1 && buffer.indexOf("</" + args[0],endTag.get(endTag.size() - 1) + 1) != -1) {
            startTag.add(buffer.indexOf("<" + args[0],startTag.get(startTag.size() - 1) + 1));
            endTag.add(buffer.indexOf("</" + args[0],endTag.get(endTag.size() - 1) + 1));
        }
        while (startTag.size() > 0) {
            int start = 0;
            int end = 0;
            int n = startTag.size();
            while (start < n - 1 && end < n - 1) {
                if (endTag.get(end) > startTag.get(start + 1)) {
                    end++;
                    start++;
                } else {
                    break;
                }
            }
            String buf = buffer.substring(startTag.get(0),endTag.get(end) + (3 + args[0].length()));
            System.out.println(buf);
            startTag.remove(0);
            endTag.remove(end);
        }
    }
}
