package huynh198.com.github.service;

import huynh198.com.github.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public List<CategoryDTO> getAllCategory();

    public CategoryDTO getCategoryById(int id);
}
