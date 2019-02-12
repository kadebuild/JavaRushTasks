package com.javarush.test.level09.lesson08.task04;

import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;

/* Перехват checked исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..
*/

public class Solution {
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
            catch (IOException | NoSuchFieldException e)
            {
                System.out.println(e);
            }
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
