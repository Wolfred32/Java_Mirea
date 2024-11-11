package ru.mirea.filyev.pract1;

import java.util.*;

public class A1_Task2
{
    public static void main(String[] args) {
        // Чтение входных данных
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Разделение входной строки на два массива
        String[] parts = input.split("_");
        String[] firstArrayStr = parts[0].trim().split(" ");
        String[] secondArrayStr = parts[1].trim().split(" ");

        // Преобразование первого массива в множество для быстрого поиска
        Set<Integer> firstSet = new HashSet<>();
        for (String numStr : firstArrayStr) {
            firstSet.add(Integer.parseInt(numStr));
        }

        // Множество для хранения общих элементов (чтобы избежать дубликатов)
        Set<Integer> commonValuesSet = new HashSet<>();
        for (String numStr : secondArrayStr) {
            int num = Integer.parseInt(numStr);
            if (firstSet.contains(num)) {
                commonValuesSet.add(num);  // Добавляем только общие элементы
            }
        }

        // Преобразование множества общих значений в список и сортировка
        List<Integer> commonValues = new ArrayList<>(commonValuesSet);
        Collections.sort(commonValues);

        // Формирование результата через StringBuilder
        StringBuilder res = new StringBuilder();
        for (int n : commonValues) {
            res.append(n).append(" ");
        }
        res = new StringBuilder(res.toString().trim()); // Убираем последний пробел

        // Вывод результата
        System.out.println(res);
    }
}
