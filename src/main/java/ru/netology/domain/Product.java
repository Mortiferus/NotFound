package ru.netology.domain;

public class Product {
    int id;
    String title;
    int price;

    public boolean matches(String search) {
        if (this.getTitle().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

    public Product(int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}