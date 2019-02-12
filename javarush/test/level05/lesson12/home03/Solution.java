package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        Cat tomCat = new Cat("Tom", 4, 50);
        Dog spikeDog = new Dog("Spike", 5, 60);
        Dog taikDog = new Dog("Taik", 4, 30);
        Cat butchCat = new Cat("Butch", 3, 49);
        Mouse taffiMaouse = new Mouse("Taffi", 5, 3);
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    public static class Cat
    {
        String name;
        int age;
        int height;

        public Cat(String name, int age, int height)
        {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    }

    public static class Dog
    {
        String name;
        int age;
        int weight;

        public Dog(String name, int age, int weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }
}
