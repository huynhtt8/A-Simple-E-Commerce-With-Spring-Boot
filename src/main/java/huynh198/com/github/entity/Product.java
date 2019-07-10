package huynh198.com.github.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_description")
    private String productDescription;

//    @NotEmpty(message = "Product Name is mandatory")
    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @NotNull(message="Please provide some price")
    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_image")
    private String images;

    public Product() {

    }

    public Product(String productDescription, @NotEmpty(message = "Product Name is mandatory") String productName, Category category, @NotNull(message = "Please provide some price") @Min(value = 100, message = "Minimum value should be greater than 100") double productPrice, String images) {
        this.productDescription = productDescription;
        this.productName = productName;
        this.category = category;
        this.productPrice = productPrice;
        this.images = images;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", productPrice=" + productPrice +
                ", images='" + images + '\'' +
                '}';
    }
}
