package com.hashkart.product.service;

import com.hashkart.product.entities.Product_Categories;
import com.hashkart.product.entities.Product_Details;

import java.util.List;

public interface ProductService {

    public List<Product_Categories> showProducts();

    public List<Product_Details> showProductsByCategory(String category_name);
}
