package huynh198.com.github.service;

import huynh198.com.github.dao.CategoryDao;
import huynh198.com.github.entity.Category;
import huynh198.com.github.model.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<CategoryDTO> getAllCategory() {
         List<Category> categories = categoryDao.getAllCategory();
         List<CategoryDTO> categoryDTOList = new ArrayList<>();
         for (Category category : categories) {
             categoryDTOList.add(new CategoryDTO(category.getCategoryId(),category.getCategoryName(),category.getCategoryDecription()));
         }
         return categoryDTOList;
    }

    @Override
    public CategoryDTO getCategoryById(int id) {
        Category category = categoryDao.getCategoryById(id);
        return new CategoryDTO(category.getCategoryId(),category.getCategoryName(),category.getCategoryDecription());
    }
}
