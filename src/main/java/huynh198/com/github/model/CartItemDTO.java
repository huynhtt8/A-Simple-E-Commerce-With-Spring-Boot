package huynh198.com.github.model;

public class CartItemDTO {

    private int cartItemId;

    private int quantity;

    private double totalCost;

    private ProductDTO productDTO;

    public CartItemDTO(int cartItemId, int quantity, double totalCost, ProductDTO productDTO) {
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.productDTO = productDTO;
    }

    public CartItemDTO() {
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
}
