package ru.mirea.filyev.pract3.task3;

import java.util.concurrent.Semaphore;

public class Therapist {
    private final Semaphore therapistRoom;

    public Therapist() {
        therapistRoom = new Semaphore(1); // Только один пациент у терапевта
    }

    public void seePatient(Patient patient) throws InterruptedException {
        therapistRoom.acquire(); // Занимаем кабинет
        System.out.println(patient.getName() + " is being seen by the therapist.");
        Thread.sleep(1000); // Симуляция осмотра терапевтом
        System.out.println(patient.getName() + " finished with the therapist.");
        therapistRoom.release(); // Освобождаем кабинет
    }
}

