package ru.mirea.filyev.pract3.task2;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Window[] windows = new Window[3];
        windows[0] = new Window("Window 1 (Any)", null); // Первое окно принимает всех
        windows[1] = new Window("Window 2 (Old only)", Person.Category.OLD); // Второе окно только для пожилых
        windows[2] = new Window("Window 3 (Businessmen only)", Person.Category.BUSINESSMAN); // Третье окно только для бизнесменов

        int totalPeople = 100;
        int youngCount = 0, oldCount = 0, businessmanCount = 0;

        // Создаем потоки граждан
        Person[] people = new Person[totalPeople];
        Random rand = new Random();
        Thread[] threads = new Thread[totalPeople]; // Массив для хранения потоков

        for (int i = 0; i < totalPeople; i++) {
            int categoryNum = rand.nextInt(3);
            Person.Category category;
            if (categoryNum == 0) {
                category = Person.Category.YOUNG;
                youngCount++;
            } else if (categoryNum == 1) {
                category = Person.Category.OLD;
                oldCount++;
            } else {
                category = Person.Category.BUSINESSMAN;
                businessmanCount++;
            }
            people[i] = new Person(category, windows);
            threads[i] = new Thread(people[i]); // Создаем поток, передавая в него объект Person
        }

        // Запускаем потоки
        for (Thread thread : threads) {
            thread.start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Выводим статистику
        int youngLeft = Person.getYoungLeft();
        int oldLeft = Person.getOldLeft();
        int businessmanLeft = Person.getBusinessmanLeft();

        System.out.println("\n--- Simulation finished ---");
        System.out.println("Total young people: " + youngCount);
        System.out.println("Total old people: " + oldCount);
        System.out.println("Total businessmen: " + businessmanCount);

        System.out.println("Young left: " + youngLeft + " (" + (youngLeft * 100.0 / youngCount) + "%)");
        System.out.println("Old left: " + oldLeft + " (" + (oldLeft * 100.0 / oldCount) + "%)");
        System.out.println("Businessmen left: " + businessmanLeft + " (" + (businessmanLeft * 100.0 / businessmanCount) + "%)");
    }
}
