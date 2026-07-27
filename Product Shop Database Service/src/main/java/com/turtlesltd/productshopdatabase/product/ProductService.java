package com.turtlesltd.productshopdatabase.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        productRepository.deleteById(id);
    }




}
