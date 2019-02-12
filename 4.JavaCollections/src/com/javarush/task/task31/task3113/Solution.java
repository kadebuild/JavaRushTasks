package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path directory = Paths.get(reader.readLine());
        reader.close();
        final int[] numberOfDirectory = {-1};
        final int[] numberOfFile = {0};
        final long[] sizeOfDirectory = {0};
        if (!Files.isDirectory(directory)) {
            System.out.println(directory.toAbsolutePath().toString() + " - не папка");
        } else {
            Files.walkFileTree(directory,
                    new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path filePath, BasicFileAttributes attrs) throws IOException {
                            numberOfFile[0]++;
                            sizeOfDirectory[0] += Files.size(filePath);
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                            numberOfDirectory[0]++;
                            return FileVisitResult.CONTINUE;
                        }
                    }
            );
            System.out.println("Всего папок - " + numberOfDirectory[0]);
            System.out.println("Всего файлов - " + numberOfFile[0]);
            System.out.println("Общий размер - " + sizeOfDirectory[0]);
        }
    }
}
