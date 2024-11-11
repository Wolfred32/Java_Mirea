package ru.mirea.filyev.pract3.task3;

import java.util.concurrent.Semaphore;

public class MRI {
    private final Semaphore mriRoom;

    public MRI() {
        mriRoom = new Semaphore(1); // Только один пациент в кабинете МРТ
    }

    public void examinePatient(Patient patient) throws InterruptedException {
        mriRoom.acquire(); // Занимаем кабинет МРТ
        System.out.println(patient.getName() + " is being examined by the MRI.");
        Thread.sleep(2000); // Симуляция обследования на МРТ
        System.out.println(patient.getName() + " finished MRI examination.");
        mriRoom.release(); // Освобождаем кабинет МРТ
    }
}

