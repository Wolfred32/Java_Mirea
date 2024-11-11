package ru.mirea.filyev.pract3.task2;

import java.util.Random;

public class Person implements Runnable{
    public enum Category {YOUNG, OLD, BUSINESSMAN}

    private final Category category;
    private final Window[] windows;
    private static int youngLeft = 0;
    private static int oldLeft = 0;
    private static int businessmanLeft = 0;

    public Person(Category category, Window[] windows) {
        this.category = category;
        this.windows = windows;
    }

    // Реализуем метод run() интерфейса Runnable
    public void run() {
        Random rand = new Random();
        boolean serviced = false;
        int attempts = 0;

        // Пытаемся выбрать окно (не больше чем 3 попытки)
        while (!serviced && attempts < 3) {
            Window window = windows[rand.nextInt(windows.length)];
            serviced = window.service(this);
            attempts++;
        }

        if (!serviced) {
            // Если гражданин не смог получить услугу, он уходит
            synchronized (Person.class) {
                if (category == Category.YOUNG) youngLeft++;
                else if (category == Category.OLD) oldLeft++;
                else businessmanLeft++;
            }
        }
    }

    public Category getCategory() {
        return category;
    }

    public static synchronized int getYoungLeft() {
        return youngLeft;
    }

    public static synchronized int getOldLeft() {
        return oldLeft;
    }

    public static synchronized int getBusinessmanLeft() {
        return businessmanLeft;
    }
}
