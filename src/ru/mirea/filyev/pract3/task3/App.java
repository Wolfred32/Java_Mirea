package ru.mirea.filyev.pract3.task3;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Therapist therapist = new Therapist();
        MRI mri = new MRI();
        Clinic clinic = new Clinic(therapist, mri);

        // Создаем и запускаем несколько потоков пациентов
        Patient[] patients = new Patient[10];
        Thread[] threads = new Thread[patients.length];

        for (int i = 0; i < patients.length; i++) {
            patients[i] = new Patient("Patient " + (i + 1), clinic);
            threads[i] = new Thread(patients[i]);
        }

        // Запускаем потоки пациентов
        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(500); // Пациенты приходят с задержкой
        }

        // Ожидаем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Выводим максимальную длину очереди
        System.out.println("Max queue length: " + clinic.getMaxQueueLength());
    }
}

