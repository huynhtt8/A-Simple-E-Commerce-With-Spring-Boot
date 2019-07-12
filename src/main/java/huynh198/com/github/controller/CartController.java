package huynh198.com.github.controller;

import huynh198.com.github.model.CartDTO;
import huynh198.com.github.model.CartItemDTO;
import huynh198.com.github.model.ProductDTO;
import huynh198.com.github.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/add-to-cart/{productId}")
    public String getProductById(@PathVariable("productId") int productId, HttpSession httpSession,
                                 Model model) {
        ProductDTO productDTO = productService.getProductById(productId);

        if (httpSession.getAttribute("cart") == null) {
            CartDTO cartDTO = new CartDTO();
            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setProductDTO(productDTO);
            cartItemDTO.setQuantity(1);
            cartItemDTO.setTotalCost(cartItemDTO.getQuantity() * productDTO.getProductPrice());
            List<CartItemDTO> cartItemDTOList = new ArrayList<>();
            cartItemDTOList.add(cartItemDTO);

            cartDTO.setCartItem(cartItemDTOList);

            httpSession.setAttribute("cart", cartDTO);
        } else {
            CartDTO cartDTO = (CartDTO) httpSession.getAttribute("cart");
            List<CartItemDTO> cartItemDTOList = cartDTO.getCartItem();

            boolean flag = false;

            for (CartItemDTO cartItemDTO : cartItemDTOList) {
                if (cartItemDTO.getProductDTO().getProductId() == productId) {
                    cartItemDTO.setQuantity(cartItemDTO.getQuantity() + 1);
                    cartItemDTO.setTotalCost(cartItemDTO.getQuantity() * productDTO.getProductPrice());
                    flag = true;
                }
            }

            if (!flag) {
                CartItemDTO cartItemDTO = new CartItemDTO();
                cartItemDTO.setProductDTO(productDTO);
                cartItemDTO.setQuantity(1);
                cartItemDTO.setTotalCost(cartItemDTO.getQuantity() * productDTO.getProductPrice());
                cartItemDTOList.add(cartItemDTO);
                cartDTO.setCartItem(cartItemDTOList);
            }

            httpSession.setAttribute("cart", cartDTO);
        }

        CartDTO cartDTO = (CartDTO) httpSession.getAttribute("cart");
        model.addAttribute(cartDTO);
        return "redirect:/product";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession httpSession, Model model) {
        CartDTO cartDTO = (CartDTO) httpSession.getAttribute("cart");

        if (cartDTO == null) {
            model.addAttribute("cartItems", "null");

        } else {
            model.addAttribute("cartItems", cartDTO.getCartItem());
        }
        return "view-cart";
    }
}
