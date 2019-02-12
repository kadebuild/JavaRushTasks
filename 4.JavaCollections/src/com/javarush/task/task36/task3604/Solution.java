package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        System.out.println(rbt.isEmpty());
        for (int i = 0; i < 100; i++) {
            rbt.insert(i);
        }
        System.out.println(rbt.isEmpty());
        for (int i = 0; i < 100; i++) {
            System.out.println(rbt.current);
        }
    }
}
