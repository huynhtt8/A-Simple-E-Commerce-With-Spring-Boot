package huynh198.com.github.model;

import java.util.List;

public class CartDTO {

    private String cartId;

    private List<CartItemDTO> cartItem;

    private double totalPrice;

    public CartDTO(String cartId, List<CartItemDTO> cartItem, double totalPrice) {
        this.cartId = cartId;
        this.cartItem = cartItem;
        this.totalPrice = totalPrice;
    }

    public CartDTO() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItemDTO> getCartItem() {
        return cartItem;
    }

    public void setCartItem(List<CartItemDTO> cartItem) {
        this.cartItem = cartItem;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
