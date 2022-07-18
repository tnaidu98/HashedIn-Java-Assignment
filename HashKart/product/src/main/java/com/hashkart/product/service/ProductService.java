package com.hashkart.product.service;

import com.hashkart.product.entities.ProductCategories;
import com.hashkart.product.entities.ProductDetails;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<ProductCategories> showProducts();

    public List<ProductDetails> showProductsByCategory(String categoryName);
}
