package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean options = true;
        if (partOfName != null) {
            if (!file.getFileName().toString().contains(partOfName)) {
                options = false;
            }
        }
        if (partOfContent != null) {
            String content = new String(Files.readAllBytes(file));
            if (!content.contains(partOfContent)) {
                options = false;
            }
        }
        if (minSize != -1) {
            if (Files.size(file) <= minSize) {
                options = false;
            }
        }
        if (maxSize != -1) {
            if (Files.size(file) >= maxSize) {
                options = false;
            }
        }
        if (options) {
            this.foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String name) {
        this.partOfName = name;
    }

    public void setPartOfContent(String content) {
        this.partOfContent = content;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
