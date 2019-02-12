package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName,"rw")) {
            raf.seek(number);
            byte[] newstring = new byte[text.length()];
            raf.read(newstring,0,text.length());
            String nstring = convertByteToString(newstring);
            System.out.println(nstring);
            raf.seek(raf.length());
            if (nstring.equals(text)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {}
    }

    public static String convertByteToString(byte readBytes[])
    {
        return new String(readBytes);
    }
}
