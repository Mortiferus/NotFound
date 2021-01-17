package ru.netology.domain;

public class Book extends Product {
    String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.getAuthor().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}