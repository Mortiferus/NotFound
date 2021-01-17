package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private int nonexistentID = 5;
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Alice’s Adventures in Wonderland", 228, "Lewis Carroll");
    private Book secondBook = new Book(2, "Through the Looking-Glass, and What Alice Found There", 307, "Lewis Carroll");
    private Smartphone firstSmartphone = new Smartphone(3, "8.3", 49_990, "Nokia");
    private Smartphone secondSmartphone = new Smartphone(4, "5.3 4/64", 15_990, "Nokia");

    @BeforeEach
    void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralByBookAuthor() {
        Product[] expected = new Product[]{firstBook, secondBook};
        Product[] actual = manager.searchBy("lEwIs cArRoLl");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByBookTitle() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Alice’s Adventures in Wonderland");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralBySmartphoneManufacturer() {
        Product[] expected = new Product[]{firstSmartphone, secondSmartphone};
        Product[] actual = manager.searchBy("NOKIA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("8.3");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByString() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Keep calm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByID() {
        Product expected = secondBook;
        Product actual = manager.findByID(2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByNonexistentID() {
        assertNull(manager.findByID(nonexistentID));
    }

    @Test
    public void shouldRemoveByID() {
        manager.removeByID(4);
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByNonexistentID() {
        manager.removeByID(nonexistentID);
        Product[] expected = new Product[]{firstBook, secondBook, firstSmartphone, secondSmartphone};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}