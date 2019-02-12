package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String firstName;
        String lastName;
        int age;
        boolean sex;
        int height;
        int weight;

        public Human(String firstName, int age)
        {
            this.firstName = firstName;
            this.age = age;
        }

        public Human(String firstName, String lastName, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, int age, boolean sex)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, int age, boolean sex, int height, int weight)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human(String firstName, int age, boolean sex)
        {
            this.firstName = firstName;
            this.age = age;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, boolean sex)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, boolean sex)
        {
            this.firstName = firstName;
            this.sex = sex;
        }

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(int age, boolean sex)
        {
            this.age = age;
            this.sex = sex;
        }
    }
}
