package huynh198.com.github.dao;

import huynh198.com.github.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class ProductDaoImpl implements ProdutDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }



    @Override
    public Product getProductById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> getProductByCategory(int categoryId) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.category.categoryId = : categoryId");
        query.setParameter("categoryId",categoryId);
        return query.getResultList();
    }


}
