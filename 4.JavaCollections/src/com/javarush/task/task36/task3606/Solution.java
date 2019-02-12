package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File[] files = new File(this.packageName).listFiles();
        ClassFromFile classLoader = new ClassFromFile();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".class")) {
                Class clazz = classLoader.load(file.getAbsolutePath());
                for (Class interf : clazz.getInterfaces()) {
                    if (interf.getSimpleName().equals("HiddenClass")) {
                        this.hiddenClasses.add(clazz);
                        break;
                    }
                }
            }
        }
    }

    public static class ClassFromFile extends ClassLoader {
        public Class load(String name) throws ClassNotFoundException {
            try {
                byte[] classBytes = Files.readAllBytes(Paths.get(name));
                return defineClass(null, classBytes, 0, classBytes.length);
            } catch (IOException e) {}
            return null;
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        try {
            for (Class clazz : this.hiddenClasses) {
                if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    final Constructor<HiddenClass> ctor = clazz.getDeclaredConstructor();
                    ctor.setAccessible(true);
                    return ctor.newInstance();
                }
            }
        } catch (Exception e) {}
        return null;
    }
}

