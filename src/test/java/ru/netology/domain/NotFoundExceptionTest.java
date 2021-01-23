package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionTest {
    int nonexistentID = 5;
    private ProductRepository repository = new ProductRepository();

    @Test
    public void shouldCatchException() {
        assertThrows(NotFoundException.class, () -> repository.removeByID(nonexistentID));
    }
}
