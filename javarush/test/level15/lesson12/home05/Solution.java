package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(){}
    public Solution(String s){}
    public Solution(int a){}

    Solution(int a, int b){}
    Solution(int a, String s){}
    Solution(String s, int a){}

    protected Solution(boolean bool){}
    protected Solution(boolean bool, String s){}
    protected Solution(String s, boolean bool){}

    private Solution(double a) {}
    private Solution(double a, double b){}
    private Solution(double a, int b){}
}

