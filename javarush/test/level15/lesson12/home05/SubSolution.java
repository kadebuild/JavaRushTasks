package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution
{
    public SubSolution()
    {
    }

    public SubSolution(String s)
    {
        super(s);
    }

    public SubSolution(int a)
    {
        super(a);
    }

    SubSolution(int a, int b)
    {
        super(a, b);
    }

    SubSolution(int a, String s)
    {
        super(a, s);
    }

    SubSolution(String s, int a)
    {
        super(s, a);
    }

    protected SubSolution(boolean bool)
    {
        super(bool);
    }

    protected SubSolution(boolean bool, String s)
    {
        super(bool, s);
    }

    protected SubSolution(String s, boolean bool)
    {
        super(s, bool);
    }

    private SubSolution(double a) {}
    private SubSolution(double a, double b){}
    private SubSolution(double a, int b){}
}
