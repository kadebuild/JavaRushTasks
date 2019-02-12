package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> listOfFiles = new ArrayList<>();
        Path rootPath = Paths.get(root);
        Files.walkFileTree(rootPath,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                        File file = filePath.toFile();
                        if (file.isFile()) {
                            listOfFiles.add(file.getAbsolutePath());
                        }
                        return FileVisitResult.CONTINUE;
                    }
                }
        );
        return listOfFiles;

    }

    public static void main(String[] args) throws IOException {
        List<String> files = new ArrayList<>();
        files = getFileTree("D:/a");
        for (String fileName : files) {
            System.out.println(fileName);
        }
    }
}