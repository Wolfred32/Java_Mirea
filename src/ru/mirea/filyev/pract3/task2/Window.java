package ru.mirea.filyev.pract3.task2;

import java.util.concurrent.Semaphore;

public class Window {
    private final Semaphore semaphore = new Semaphore(1); // Одновременно может быть занят только один клиент
    private final String name;
    private final Person.Category allowedCategory;

    public Window(String name, Person.Category allowedCategory) {
        this.name = name;
        this.allowedCategory = allowedCategory;
    }

    public boolean service(Person person) {
        // Проверяем, подходит ли категория окна для данного гражданина
        if (allowedCategory != null && allowedCategory != person.getCategory()) {
            return false;
        }

        // Пытаемся занять окно
        if (semaphore.tryAcquire()) {
            try {
                System.out.println("Person of category " + person.getCategory() + " is being serviced at " + name);
                Thread.sleep(1000); // Симуляция времени обслуживания
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
            return true;
        } else {
            System.out.println("Window " + name + " is busy.");
            return false; // Окно занято
        }
    }
}
