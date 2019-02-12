package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("temp", ".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (final IOException e) {}
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {}
        return 0L;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            while (entry != null) {
                oos.writeObject(entry);
                entry = entry.next;
            }
        } catch (IOException e) {}
    }

    public Entry getEntry() {
        if (getFileSize() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
                Entry entry = (Entry) ois.readObject();
                Entry buf = entry;
                while (ois.available() > 0) {
                    buf.next = (Entry) ois.readObject();
                    buf = buf.next;
                }
                return entry;
            } catch (Exception e) {
            }
            return null;
        } else {
            return null;
        }
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {}
    }
}
