package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exceptions.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();

    private Product prod1 = new Book(1, "WAR", 200, "LEV", 300, 1890);
    private Product prod2 = new Book(2, "WAR2", 200, "MARKUS", 30, 1790);
    private Product prod3 = new TShirt(3, "Polo", 100, "black", "L");
    private Product prod4 = new TShirt(4, "GAP", 150, "green", "XL");

    @Test
    void removeByIdNew() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        ProductManager manager = new ProductManager(repository);
        int id = 2;
        manager.removeByIdNew(id);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{prod1, prod3, prod4};

        assertArrayEquals(actual, expected);



    }
    @Test
    void removeByIdNew2() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        ProductManager manager = new ProductManager(repository);
        int id = 7;

        assertThrows(NotFoundException.class, () -> manager.removeByIdNew(id));
    }
}
