package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Ded1", true, 60);
        Human ded2 = new Human("Ded2", true, 60);
        Human baba1 = new Human("Baba1", false,50);
        Human baba2 = new Human("Baba2", false, 50);
        Human papa = new Human("Papa", true, 30);
        Human mama = new Human("Mama", false, 29);
        Human reb1 = new Human("Reb1", true, 5);
        Human reb2 = new Human("Reb2", false, 9);
        Human reb3 = new Human("Reb3", true, 4);

        ded1.addChildren(papa);
        baba1.addChildren(papa);
        ded2.addChildren(mama);
        baba2.addChildren(mama);
        papa.addChildren(reb1);
        papa.addChildren(reb2);
        papa.addChildren(reb3);
        mama.addChildren(reb1);
        mama.addChildren(reb2);
        mama.addChildren(reb3);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(reb1);
        System.out.println(reb2);
        System.out.println(reb3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public void addChildren(Human child)
        {
            this.children.add(child);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
