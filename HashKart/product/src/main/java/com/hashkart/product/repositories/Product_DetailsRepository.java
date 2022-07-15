package com.hashkart.product.repositories;

import com.hashkart.product.entities.Product_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Product_DetailsRepository extends JpaRepository<Product_Details, Integer> {

    @Query("from Product_Details pd where pd.category_id=:category_id")
    public List<Product_Details> findByCategoryId(@Param("category_id")int category_id);

}
