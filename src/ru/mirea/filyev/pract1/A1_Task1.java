package ru.mirea.filyev.pract1;

import java.util.*;

public class A1_Task1 {

    public static void main(String[] args){

        // Чтение входных данных
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Разделение входной строки на два массива
        String[] parts = input.split("_");
        String[] firstArrayStr = parts[0].trim().split(" ");
        String[] secondArrayStr = parts[1].trim().split(" ");

        // Преобразование строковых массивов в числовые множества
        Set<Integer> firstSet = new HashSet<>();
        for (String numStr : firstArrayStr) {
            firstSet.add(Integer.parseInt(numStr));
        }

        Set<Integer> secondSet = new HashSet<>();
        for (String numStr : secondArrayStr) {
            secondSet.add(Integer.parseInt(numStr));
        }

        // Поиск пересечения двух множеств
        firstSet.retainAll(secondSet);

        // Преобразование результата в список и сортировка
        List<Integer> commonValues = new ArrayList<>(firstSet);
        Collections.sort(commonValues);

        // Вывод результата
        for (Integer value : commonValues) {
            System.out.print(value + " ");
        }
    }
}
