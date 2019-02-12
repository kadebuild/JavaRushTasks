package com.javarush.task.task31.task3106;

import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String resultFileName = args[0];

        Set<String> stringParts = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            stringParts.add(args[i]);
        };
        List<FileInputStream> zipParts = new ArrayList<>();
        for (String str : stringParts) {
            zipParts.add(new FileInputStream(str));
        }
        byte[] buffer = new byte[1024];
        int readByteCnt;
        try(ZipInputStream zipIn = new ZipInputStream(new SequenceInputStream(Collections.enumeration(zipParts)));
            FileOutputStream fileOut = new FileOutputStream(new File(resultFileName))) {
            System.out.println(zipIn.getNextEntry().toString());
            while ((readByteCnt = zipIn.read(buffer)) > 0) {
                fileOut.write(buffer, 0, readByteCnt);
                fileOut.flush();
            }
        }
    }
}
