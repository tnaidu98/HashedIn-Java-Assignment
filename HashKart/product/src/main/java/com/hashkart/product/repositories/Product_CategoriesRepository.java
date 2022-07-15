package com.hashkart.product.repositories;

import com.hashkart.product.entities.Product_Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_CategoriesRepository extends JpaRepository<Product_Categories, Integer> {

    @Query("from Product_Categories pc where pc.category_name=:category_name")
    public Product_Categories findByCategoryName(@Param("category_name")String category_name);

}
