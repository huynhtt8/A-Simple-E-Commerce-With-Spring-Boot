package huynh198.com.github.service;

import huynh198.com.github.dao.ProdutDao;
import huynh198.com.github.entity.Product;
import huynh198.com.github.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProdutDao produtDao;

    @Override
    public ProductDTO getProductById(int id) {
        Product product = produtDao.getProductById(id);
        ProductDTO productDTO = new ProductDTO();
        List<String> productDescriptions = new ArrayList<>();
        List<String> images = new ArrayList<>();
        String[] dess = product.getProductDescription().split("htt98");
        for (String des : dess) {
            productDescriptions.add(des);
        }

        productDescriptions.remove(0);

        String[] imgs = product.getImages().split(" ");
        for (String img : imgs) {

//            System.out.println("-----------------");
//            System.out.println(img);
//            System.out.println("-----------------");
            images.add(img);
        }
        images.remove(0);

        return new  ProductDTO(product.getProductId(),
                productDescriptions,product.getProductName(),product.getCategory().getCategoryName(),product.getProductPrice(),images);

    }

    @Override
    public List<ProductDTO> getProductByCategory(int categoryId) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = produtDao.getProductByCategory(categoryId);

        for (Product product : products) {
            List<String> productDescriptions = new ArrayList<>();
            List<String> images = new ArrayList<>();
            String[] dess = product.getProductDescription().split("htt98");
            for (String des : dess) {
                productDescriptions.add(des);
            }

            productDescriptions.remove(0);

            String[] imgs = product.getImages().split(" ");
            for (String img : imgs) {
                images.add(img);
            }
            images.remove(0);

            ProductDTO productDTO =  new  ProductDTO(product.getProductId(),
                    productDescriptions,product.getProductName(),product.getCategory().getCategoryName(),product.getProductPrice(),images);
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = produtDao.getAllProduct();

        for (Product product : products) {
            List<String> productDescriptions = new ArrayList<>();
            List<String> images = new ArrayList<>();
            String[] dess = product.getProductDescription().split("htt98");
            for (String des : dess) {
                productDescriptions.add(des);
            }

            productDescriptions.remove(0);

            String[] imgs = product.getImages().split(" ");
            for (String img : imgs) {
                images.add(img);
            }
            images.remove(0);

            ProductDTO productDTO =  new  ProductDTO(product.getProductId(),
                    productDescriptions,product.getProductName(),product.getCategory().getCategoryName(),product.getProductPrice(),images);
            productDTOS.add(productDTO);
        }

        return productDTOS;
    }
}
