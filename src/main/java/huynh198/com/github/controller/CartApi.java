package huynh198.com.github.controller;

import huynh198.com.github.model.CartItemDTO;
import huynh198.com.github.model.ProductDTO;
import huynh198.com.github.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CartApi {

    @Autowired
    ProductService productService;

    @PostMapping("/api/add-product-to-cart")
    public ResponseEntity<?> getProductById(@Valid @RequestBody int id) {

        ProductDTO productDTO = productService.getProductById(id);

        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setQuantity(1);
        cartItemDTO.setProductDTO(productDTO);
        return ResponseEntity.ok(cartItemDTO);
    }

}