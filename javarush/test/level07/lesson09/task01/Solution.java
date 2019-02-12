package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list20Numbers = new ArrayList<Integer>();
        ArrayList<Integer> listDiv3 = new ArrayList<Integer>();
        ArrayList<Integer> listDiv2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++)
        {
            list20Numbers.add(Integer.parseInt(reader.readLine()));
            if (list20Numbers.get(i) % 3 == 0)
                listDiv3.add(list20Numbers.get(i));
            if (list20Numbers.get(i) % 2 == 0)
                listDiv2.add(list20Numbers.get(i));
            if (list20Numbers.get(i) % 3 != 0 && list20Numbers.get(i) % 2 != 0)
                listOther.add(list20Numbers.get(i));
        }
        printList(listDiv3);
        printList(listDiv2);
        printList(listOther);
    }

    public static void printList(List<Integer> list)
    {
        for (int i = 0, n = list.size(); i < n; i++)
            System.out.println(list.get(i));
    }
}
