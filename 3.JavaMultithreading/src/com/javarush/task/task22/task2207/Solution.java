package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader = new BufferedReader(new FileReader(fileName));
        List<String> wordList = new ArrayList<>();
        while (reader.ready()) {
            Collections.addAll(wordList,reader.readLine().split(" "));
        }
        reader.close();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < wordList.size()-1; i++) {
            if (wordList.get(i) != null) {
                stringBuilder = new StringBuilder(wordList.get(i)).reverse();
            }
            for (int j = i+1; j < wordList.size(); j++) {
                if (wordList.get(i) == null || wordList.get(j) == null) {
                    break;
                }
                if (stringBuilder.toString().equals(wordList.get(j))) {
                    Pair pair = new Pair();
                    pair.first = wordList.get(i);
                    pair.second = wordList.get(j);
                    result.add(pair);
                    wordList.set(i,null);
                    wordList.set(j,null);
                }
            }
        }
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
