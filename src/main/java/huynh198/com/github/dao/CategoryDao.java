package huynh198.com.github.dao;

import huynh198.com.github.entity.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAllCategory();

    public Category getCategoryById(int id);
}
