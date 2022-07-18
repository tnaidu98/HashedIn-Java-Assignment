package com.hashkart.product.repositories;

import com.hashkart.product.entities.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {
    public List<ProductDetails> findByCategoryId(@Param("categoryId")int categoryId);

}
