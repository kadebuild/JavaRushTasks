package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;
    public int num;

    public Circle() {
        this(1,2,3,4);
    }

    public Circle(double x) {
        this.x = x;
    }

    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle (double x, double y, double radius, int num) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.num = num;
    }

    public static void main(String[] args) {

    }
}