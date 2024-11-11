package ru.mirea.filyev.pract3.task3;

import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private final Therapist therapist;
    private final MRI mri;
    private final Queue<Patient> patientQueue;
    private int maxQueueLength = 0;

    public Clinic(Therapist therapist, MRI mri) {
        this.therapist = therapist;
        this.mri = mri;
        this.patientQueue = new LinkedList<>();
    }

    // Метод для посещения терапевта
    public synchronized void visitTherapist(Patient patient) throws InterruptedException {
        patientQueue.add(patient); // Пациент встал в очередь
        maxQueueLength = Math.max(maxQueueLength, patientQueue.size()); // Отслеживаем максимальную длину очереди
        System.out.println(patient.getName() + " is waiting for the therapist.");

        while (patientQueue.peek() != patient) {
            wait(); // Ждём своей очереди
        }

        therapist.seePatient(patient); // Пациент заходит к терапевту
    }

    // Метод для посещения кабинета МРТ
    public synchronized void visitMRI(Patient patient) throws InterruptedException {
        mri.examinePatient(patient); // Пациент отправляется в МРТ
        patientQueue.poll(); // Пациент покидает очередь после завершения осмотра в МРТ
        notifyAll(); // Уведомляем, что следующий пациент может зайти
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }
}

