package huynh198.com.github.service;

import huynh198.com.github.entity.Product;
import huynh198.com.github.model.ProductDTO;

import java.util.List;

public interface ProductService {
    public ProductDTO getProductById(int id);
    public List<ProductDTO> getProductByCategory(int categoryId);
    public List<ProductDTO> getAllProduct();
}
