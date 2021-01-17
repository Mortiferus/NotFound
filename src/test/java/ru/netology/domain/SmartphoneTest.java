package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Book book = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private Smartphone smartphone = new Smartphone(3, "8.3", 49_990, "Nokia");

    @Test
    void shouldNotMatchesSearch() {
        boolean actual = smartphone.matches("");
        assertEquals(false, actual);
    }

    @Test
    void shouldMatchesBookByTitle() {
        boolean actual = smartphone.matches("8.3");
        assertEquals(true, actual);
    }

    @Test
    void shouldMatchesBookByManufacturer() {
        boolean actual = smartphone.matches("Nokia");
        assertEquals(true, actual);
    }
}