package ru.netology.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exceptions.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Product prod1 = new Book(1, "WAR", 200, "LEV", 300, 1890);
    private Product prod2 = new Book(2, "WAR2", 200, "MARKUS", 30, 1790);
    private Product prod3 = new TShirt(3, "Polo", 100, "black", "L");
    private Product prod4 = new TShirt(4, "GAP", 150, "green", "XL");


    @Test
    void removeById() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        int id = 2;
        repository.removeById(id);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{prod1, prod3, prod4};

        assertArrayEquals(actual, expected);

    }

    @Test
    void removeById2() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        int id = 5;

        assertThrows(NotFoundException.class, () -> repository.removeById(id));
    }

}

