package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;
import java.nio.Buffer;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        if (age < 18)
            System.out.println("Подрасти еще");
    }
}
