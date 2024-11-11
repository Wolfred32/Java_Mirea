package ru.mirea.filyev.pract3.task1;

import java.util.concurrent.CopyOnWriteArrayList;

public class App {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>();

        // Создаем объекты для записи и чтения
        Writer writer = new Writer(listOfNumbers);
        Reader reader = new Reader(listOfNumbers);

        // Запускаем их в отдельных потоках
        Thread writerThread = new Thread(writer);
        Thread readerThread = new Thread(reader);

        writerThread.start();
        readerThread.start();
    }
}
