package ru.netology.domain;

public class Smartphone extends Product {
    String manufacturer;

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.getManufacturer().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}