package com.javarush.task.task19.task1916;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
        ArrayList<String> f1List = new ArrayList<>();
        ArrayList<String> f2List = new ArrayList<>();
        String buf;
        while ((buf = fileReader1.readLine()) != null) {
            f1List.add(buf);
        }
        while ((buf = fileReader2.readLine()) != null) {
            f2List.add(buf);
        }
        fileReader1.close();
        fileReader2.close();
        while (f1List.size() > 0 || f2List.size() > 0) {
            if (f1List.size() == 1 && f2List.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, f1List.get(0)));
                f1List.remove(0);
            } else if (f2List.size() == 1 && f1List.size() == 0) {
                lines.add(new LineItem(Type.ADDED, f2List.get(0)));
                f2List.remove(0);
            } else if (f1List.get(0).equals(f2List.get(0))) {
                lines.add(new LineItem(Type.SAME, f1List.get(0)));
                f1List.remove(0);
                f2List.remove(0);
            } else if (f2List.get(1).equals(f1List.get(0))) {
                lines.add(new LineItem(Type.ADDED, f2List.get(0)));
                f2List.remove(0);
            } else if (f1List.get(1).equals(f2List.get(0))) {
                lines.add(new LineItem(Type.REMOVED, f1List.get(0)));
                f1List.remove(0);
            }
        }
        for (LineItem eachItem : lines) {
            System.out.println(eachItem.type + " " + eachItem.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
