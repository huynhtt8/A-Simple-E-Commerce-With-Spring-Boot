package huynh198.com.github.dao;

import huynh198.com.github.entity.Product;

import java.util.List;

public interface ProdutDao {
    public Product getProductById(int id);
    public List<Product> getProductByCategory(int categoryId);
    public List<Product> getAllProduct();
}
