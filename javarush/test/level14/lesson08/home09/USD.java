package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Admin on 08.01.2017.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName() {return "USD";}
}
