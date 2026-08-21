package org.trutlesltd.mid_practice_product_shop_database;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Long id, Product UpdateProduct){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null) {
            product.setName(UpdateProduct.getName());
            product.setCategory(UpdateProduct.getCategory());
            product.setStock(UpdateProduct.getStock());
            product.setPrice(UpdateProduct.getPrice());

            productRepository.save(product);
        }
    }




}
