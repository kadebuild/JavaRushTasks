package com.javarush.task.task35.task3507;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File[] files = new File(pathToAnimals).listFiles();
        Set<Animal> animalSet = new HashSet<>();
        for (File file : files) {
            try {
                ClassFromFile classLoader = new ClassFromFile();
                if (file.isFile() && file.getName().endsWith(".class")) {
                    Class<?> clazz = classLoader.load(file.getAbsolutePath());
                    animalSet.add((Animal) clazz.newInstance());
                }
            } catch (Exception e) {}
        }
        return animalSet;
    }

    public static class ClassFromFile extends ClassLoader {
        public Class<?> load(String name) throws ClassNotFoundException {
            try {
                byte[] classBytes = Files.readAllBytes(Paths.get(name));
                return defineClass(null, classBytes, 0, classBytes.length);
            } catch (IOException e) {}
            return null;
        }
    }
}
