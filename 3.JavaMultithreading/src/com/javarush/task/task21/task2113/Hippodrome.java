package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horsesm = new ArrayList<>();
        horsesm.add(new Horse("One",3,0));
        horsesm.add(new Horse("Two",3,0));
        horsesm.add(new Horse("Three",3,0));
        game = new Hippodrome(horsesm);
        game.run();
        game.printWinner();
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; ++i) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 10; ++i) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winnerHorse = new Horse("buffer",0,0);
        for (Horse horse : getHorses()) {
            if (horse.getDistance() > winnerHorse.getDistance()) {
                winnerHorse = horse;
            }
        }
        return winnerHorse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
