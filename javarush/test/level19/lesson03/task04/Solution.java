package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] fio = new String[3];
            int[] bdDate = new int[3];
            for (int i = 0; i < 3; i++)
                fio[i] = scanner.next();
            for (int i = 0; i < 3; i++)
                bdDate[i] = scanner.nextInt();
            Date bd = new Date(bdDate[2]-1900,bdDate[1]-1,bdDate[0]);
            Person person = new Person(fio[1], fio[2], fio[0], bd);
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }
}
