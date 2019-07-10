package huynh198.com.github.dao;

import huynh198.com.github.entity.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Category> getAllCategory() {
        return entityManager.createQuery("SELECT c FROM Category c",Category.class).getResultList();
    }

    @Override
    public Category getCategoryById(int id) {
        return entityManager.find(Category.class,id);
    }
}
