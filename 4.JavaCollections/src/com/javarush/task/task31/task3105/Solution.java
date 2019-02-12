package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> zipEntries2 = new ArrayList<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))) {
            int zipbyte;
            while (zipInputStream.available() != 0) {
                while ((zipbyte = zipInputStream.read()) > 0) {
                    zipEntries2.add(zipbyte);
                }
                zipInputStream.getNextEntry();
            }
        }
        ZipFile zipFile = new ZipFile(args[1]);
        Map<String, byte[]> entryMap = new HashMap<>();
        Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
        while (zipEntries.hasMoreElements()) {
            ZipEntry zipEntry = zipEntries.nextElement();
            if (!zipEntry.isDirectory()) {
                InputStream inputStream = zipFile.getInputStream(zipEntry);
                byte[] buff = new byte[inputStream.available()];
                inputStream.read(buff);
                inputStream.close();
                entryMap.put(zipEntry.getName(), buff);
            }
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))) {
            Path newFilePath = Paths.get(args[0]);
            String newFileName = newFilePath.getFileName().toString();
            for (Map.Entry<String, byte[]> mapEntry : entryMap.entrySet()) {
                if (!mapEntry.getKey().equals(newFileName) && !mapEntry.getKey().equals("new/" + newFileName)) {
                    zipOutputStream.putNextEntry(new ZipEntry(mapEntry.getKey()));
                    zipOutputStream.write(mapEntry.getValue());
                }
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + newFileName));
            Files.copy(newFilePath, zipOutputStream);
        }
    }
}