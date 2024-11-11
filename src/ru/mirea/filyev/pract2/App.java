package ru.mirea.filyev.pract2;

import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class App {
    public static void main(String[] args) {
        String[] bookNames = new String[] {
                "All you need is kill", "Made in Abyss",
                "Spy x Family", "Jujutsu Kaisen", "Chainsaw Man",
                "One Piece", "Hunter x Hunter", "Berserk", "Vinland Saga",
                "Demon Slayer"
        };

        String[] names = new String[] {
                "Митя", "Серёга", "Артурио", "Санёчек", "Мишаня"
        };

        Library library = new Library();

        // Заполняем каталог книг
        for (String bookName : bookNames) {
            library.addToCatalog(new Book(bookName));
        }

        // Добавляем читателей в библиотеку
        for (String name : names) {
            Reader reader = new Reader(name);
            library.addReader(reader);
        }

        // Выдаем каждому читателю случайное количество доступных книг
        Random random = new Random();
        for (Reader reader : library.getReaders()) {
            int booksToTake = random.nextInt(3) + 1; // случайное число книг (от 1 до 3)
            for (int i = 0; i < booksToTake; i++) {
                List<Book> availableBooks = library.getCatalog();
                if (!availableBooks.isEmpty()) {
                    int bookIndex = random.nextInt(availableBooks.size());
                    Book bookToTake = availableBooks.get(bookIndex);
                    reader.takeBook(bookToTake);
                    library.getBook(bookToTake.getName()); // Удаляем книгу из каталога
                }
            }
        }

        // 1. Текущее количество книг в библиотеке и их названия
        System.out.println("Текущее количество книг в библиотеке: " + library.getCatalog().size());
        System.out.println("Книги, доступные в библиотеке:");
        library.getCatalog().forEach(book -> System.out.println(" - " + book.getName()));

        // 2. Текущее количество читателей и их имена
        System.out.println("\nТекущее количество читателей: " + library.getReaders().size());
        System.out.println("Имена читателей:");
        library.getReaders().forEach(reader -> System.out.println(" - " + reader.getName()));

        // 3. Сколько книг всего находится у читателей
        int totalBooksWithReaders = library.getReaders().stream()
                .mapToInt(reader -> reader.getTakenBooks().size())
                .sum();
        System.out.println("\nОбщее количество книг у читателей: " + totalBooksWithReaders);
        System.out.println("Читатели и их книги:");
        library.getReaders().forEach(reader -> {
            System.out.println(reader.getName() + " взял книги: " + reader.getTakenBooks());
        });
    }
}
