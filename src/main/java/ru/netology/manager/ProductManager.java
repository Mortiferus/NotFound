package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] findByID(int id) {
        return repository.findByID(id);
    }

    public void removeByID(int id) {
            repository.removeByID(id);
    }

    public Product[] searchBy(String search) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}