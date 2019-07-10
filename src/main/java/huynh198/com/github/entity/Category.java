package huynh198.com.github.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "category")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_decription")
    private String categoryDecription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;


    public Category(String categoryName, String categoryDecription, List<Product> products) {
        this.categoryName = categoryName;
        this.categoryDecription = categoryDecription;
        this.products = products;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCategoryDecription() {
        return categoryDecription;
    }

    public void setCategoryDecription(String categoryDecription) {
        this.categoryDecription = categoryDecription;
    }
}
