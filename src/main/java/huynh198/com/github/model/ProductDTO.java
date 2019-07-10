package huynh198.com.github.model;

import huynh198.com.github.entity.Category;

import java.util.List;

public class ProductDTO {
    private int productId;

    private List<String> productDescriptions;

    private String productName;

    private String category;

    private double productPrice;

    private List<String> images;

    public ProductDTO(int productId, List<String> productDescriptions, String productName, String category, double productPrice, List<String> images) {
        this.productId = productId;
        this.productDescriptions = productDescriptions;
        this.productName = productName;
        this.category = category;
        this.productPrice = productPrice;
        this.images = images;
    }

    public ProductDTO() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public List<String> getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(List<String> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public List<String> getImages() {
        return images;
    }

    public String getOneImage() {

        System.out.println(images.get(0));
        return images.get(0);
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productDescriptions=" + productDescriptions +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", productPrice=" + productPrice +
                ", images=" + images +
                '}';
    }
}
