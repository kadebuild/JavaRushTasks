package com.javarush.test.level09.lesson08.task05;

/* Перехват unchecked исключений
В методе processExceptions обработайте все unchecked исключения.
Нужно вывести стек-трейс каждого возникшего исключения используя метод printStack.
Можно использовать только один блок try..
*/

public class Solution
{
    public static void main(String[] args) {
        processExceptions(new Solution());
    }

    public static void processExceptions(Solution obj) {
        int numOfError = 0;
        while (numOfError < 3)
        {
            try
            {
                if (numOfError == 0)
                {
                    numOfError++;
                    obj.method1();
                }
                else if (numOfError == 1)
                {
                    numOfError++;
                    obj.method2();
                }
                else
                {
                    numOfError++;
                    obj.method3();
                }
            }
            catch (NullPointerException | IndexOutOfBoundsException | NumberFormatException e)
            {
                printStack(e);
            }
        }
    }

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }

    public void method1(){
        throw new NullPointerException();
    }

    public void method2() {
        throw new IndexOutOfBoundsException();
    }

    public void method3() {
        throw new NumberFormatException();
    }
}
