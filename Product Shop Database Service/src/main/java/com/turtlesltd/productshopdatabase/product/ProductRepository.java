package com.turtlesltd.productshopdatabase.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository   //optional
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    Built-in Repository Methods
//    findAll()
//    findById()
//    save()
//    deleteById()



    //Query Methods
    //select * from product where stock > 10
    List<Product> findAllByStockGreaterThan(int stock);

    //select * from product where stock < 10
    List<Product> findAllByStockLessThan(int stock);

    //select * from product name = ? and category = ?
    List<Product> findALlByNameEqualsAndCategoryIgnoreCase(String name, String category);



    //custom query
    //@Query()


}
