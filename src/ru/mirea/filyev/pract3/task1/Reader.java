package ru.mirea.filyev.pract3.task1;

import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;

    public Reader(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Current list: " + listOfNumbers);
        }
    }
}
