package ru.mirea.filyev.pract3.task1;

import java.util.concurrent.CopyOnWriteArrayList;

public class Writer implements Runnable {
    private final CopyOnWriteArrayList<Integer> listOfNumbers;

    public Writer(CopyOnWriteArrayList<Integer> listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listOfNumbers.add(i);
            System.out.println("Write: " + i);
        }
    }
}
