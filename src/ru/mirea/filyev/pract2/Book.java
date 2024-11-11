package ru.mirea.filyev.pract2;

public class Book {
    private String name;

    private String author;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return (name);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
