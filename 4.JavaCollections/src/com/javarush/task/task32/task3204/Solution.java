package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i ++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random r = new Random();
        int bigLetter = 0, smallLetter = 0, digit = 0;
        while (byteArrayOutputStream.size() < 8) {
            Long generated = Math.round(Math.random()*11);
            if (generated < 4) {
                if (smallLetter == 0 || (bigLetter > 0 && digit > 0)) {
                    byteArrayOutputStream.write(r.nextInt(122 - 97) + 97);
                    smallLetter++;
                } else {
                    if (bigLetter == 0) {
                        byteArrayOutputStream.write(r.nextInt(90 - 65) + 65);
                        bigLetter++;
                    } else if (digit == 0) {
                        byteArrayOutputStream.write(r.nextInt(57 - 48) + 48);
                        digit++;
                    }
                }
            }
            if (generated >= 4 && generated < 8) {
                if (bigLetter == 0 || (smallLetter > 0 && digit > 0)) {
                    byteArrayOutputStream.write(r.nextInt(90 - 65) + 65);
                    bigLetter++;
                } else {
                    if (smallLetter == 0) {
                        byteArrayOutputStream.write(r.nextInt(122 - 97) + 97);
                        smallLetter++;
                    } else if (digit == 0) {
                        byteArrayOutputStream.write(r.nextInt(57 - 48) + 48);
                        digit++;
                    }
                }
            }
            if (generated >= 8) {
                if (digit == 0 || (smallLetter > 0 && bigLetter > 0)) {
                    byteArrayOutputStream.write(r.nextInt(57 - 48) + 48);
                    digit++;
                } else {
                    if (smallLetter == 0) {
                        byteArrayOutputStream.write(r.nextInt(122 - 97) + 97);
                        smallLetter++;
                    } else if (bigLetter == 0) {
                        byteArrayOutputStream.write(r.nextInt(90 - 65) + 65);
                        bigLetter++;
                    }
                }
            }
            try {
                byteArrayOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream;
    }
}