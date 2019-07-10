package huynh198.com.github.controller;

import huynh198.com.github.model.CategoryDTO;
import huynh198.com.github.model.ProductDTO;
import huynh198.com.github.service.CategoryService;
import huynh198.com.github.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("msg","Hello Huynh Trinh");
        return "index";
    }

    @GetMapping("/product")
    public String listAllProduct(Model model){
        List<ProductDTO> productDTOS = productService.getAllProduct();
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
        model.addAttribute(productDTOS);
        model.addAttribute(categoryDTOList);
        return "view-all-product";
    }

    @GetMapping("/product/{productId}")
    public String getProductById(@PathVariable("productId") int productId,Model model){
        ProductDTO productDTO = productService.getProductById(productId);
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
        model.addAttribute(categoryDTOList);
        model.addAttribute(productDTO);
        return "view-product";
    }

    @GetMapping("/product/category/{categoryId}")
    public String getAllProductByCategory(@PathVariable("categoryId") int categoryId,Model model){
        List<ProductDTO> productDTOList = productService.getProductByCategory(categoryId);
        model.addAttribute(productDTOList);
        List<CategoryDTO> categoryDTOList = categoryService.getAllCategory();
        model.addAttribute(categoryDTOList);

        CategoryDTO categoryDTO = categoryService.getCategoryById(categoryId);
        model.addAttribute(categoryDTO);
        return "view-product-category";
    }
}
