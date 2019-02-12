package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Zerg zerg1 = new Zerg();
        zerg1.name = "Z1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Z2";
        Zerg zerg10 = new Zerg();
        zerg10.name = "Z10";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Z3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Z4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Z5";
        Zerg zerg6 = new Zerg();
        zerg6.name = "Z6";
        Zerg zerg7 = new Zerg();
        zerg7.name = "Z7";
        Zerg zerg8 = new Zerg();
        zerg8.name = "Z8";
        Zerg zerg9 = new Zerg();
        zerg9.name = "Z9";

        Protos prot1 = new Protos();
        prot1.name = "P1";
        Protos prot2 = new Protos();
        prot2.name = "P2";
        Protos prot3 = new Protos();
        prot3.name = "P3";
        Protos prot4 = new Protos();
        prot4.name = "P4";
        Protos prot5 = new Protos();
        prot5.name = "P5";

        Terran ter1 = new Terran();
        ter1.name = "T1";
        Terran ter2 = new Terran();
        ter2.name = "T2";
        Terran ter3 = new Terran();
        ter3.name = "T3";
        Terran ter4 = new Terran();
        ter4.name = "T4";
        Terran ter5 = new Terran();
        ter5.name = "T5";
        Terran ter6 = new Terran();
        ter6.name = "T6";
        Terran ter7 = new Terran();
        ter7.name = "T7";
        Terran ter8 = new Terran();
        ter8.name = "T8";
        Terran ter9 = new Terran();
        ter9.name = "T9";
        Terran ter10 = new Terran();
        ter10.name = "T10";
        Terran ter11 = new Terran();
        ter11.name = "T11";
        Terran ter12 = new Terran();
        ter12.name = "T12";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}