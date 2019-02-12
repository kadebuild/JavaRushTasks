package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, File> listOfFiles = new TreeMap<>();
        Path filePath = Paths.get(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File newFileContent = new File (resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFileContent);
        try (FileOutputStream outputStream = new FileOutputStream(newFileContent)) {
            /*for (File file : path.listFiles()) {
                if (file.length() > 50) {
                    FileUtils.deleteFile(file);
                } else {
                    if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            if (file2.length() > 50) {
                                FileUtils.deleteFile(file2);
                            } else {
                                listOfFiles.add(file2);
                            }
                        }
                    } else {
                        listOfFiles.add(file);
                    }
                }
            }*/
            Files.walkFileTree(filePath,
                    new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                            if (!filePath.equals(resultFileAbsolutePath)) {
                                File file = filePath.toFile();
                                if (file.length() > 50) {
                                    FileUtils.deleteFile(file);
                                } else {
                                    listOfFiles.put(file.getName(),file);
                                }
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    }
            );
            for (Map.Entry<String, File> pair : listOfFiles.entrySet()) {
                FileInputStream inputStream = new FileInputStream(pair.getValue());
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read());
                }
                outputStream.write(System.lineSeparator().getBytes());
                inputStream.close();
            }
            outputStream.close();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
