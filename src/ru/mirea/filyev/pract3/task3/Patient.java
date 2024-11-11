package ru.mirea.filyev.pract3.task3;

public class Patient implements Runnable {
    private final String name;
    private final Clinic clinic;

    public Patient(String name, Clinic clinic) {
        this.name = name;
        this.clinic = clinic;
    }

    @Override
    public void run() {
        try {
            clinic.visitTherapist(this);
            clinic.visitMRI(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String getName() {
        return name;
    }
}

