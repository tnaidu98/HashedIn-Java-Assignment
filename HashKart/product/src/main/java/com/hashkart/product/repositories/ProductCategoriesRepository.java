package com.hashkart.product.repositories;

import com.hashkart.product.entities.ProductCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategories, Integer> {
    public ProductCategories findByCategoryName(@Param("categoryName")String categoryName);

}
