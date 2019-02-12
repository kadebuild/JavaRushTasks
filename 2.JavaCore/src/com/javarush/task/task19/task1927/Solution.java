package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String[] res = result.split("\n");
        StringBuilder stringBuild = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuild.append(res[i]);
            if (i != res.length-1) {
                stringBuild.append("\n");
            }
            if (i%2 != 0) {
                stringBuild.append("JavaRush - курсы Java онлайн\n");
            }
        }
        result = stringBuild.toString();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
