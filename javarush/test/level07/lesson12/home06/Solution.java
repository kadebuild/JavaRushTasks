package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Дед1", true, 50, null, null);
        Human ded2 = new Human("Дед2", true, 50, null, null);
        Human baba1 = new Human("Баба1", false, 60, null, null);
        Human baba2 = new Human("Баба2", false, 50, null, null);
        Human papa = new Human("Папа", true, 30, ded1, baba1);
        Human mama = new Human("Мама", false, 30, ded2, baba2);
        Human rebenok1 = new Human("Ребенок1", true, 5, papa, mama);
        Human rebenok2 = new Human("Ребенок2", false, 6, papa, mama);
        Human rebenok3 = new Human("Ребенок3", true, 10, papa, mama);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(baba1);
        System.out.println(baba2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(rebenok1);
        System.out.println(rebenok2);
        System.out.println(rebenok3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
