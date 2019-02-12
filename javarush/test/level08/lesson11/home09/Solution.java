package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 29 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        Date data = new Date(date);
        Date startYearDate = new Date(date);
        startYearDate.setMonth(0);
        startYearDate.setDate(1);
        long dayFromStartYear = (data.getTime()-startYearDate.getTime())/3600/24/1000;
        if (dayFromStartYear % 2 == 0)
            return true;
        else
            return false;
    }
}
