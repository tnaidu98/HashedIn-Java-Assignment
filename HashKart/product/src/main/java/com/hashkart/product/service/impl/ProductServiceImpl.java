package com.hashkart.product.service.impl;

import com.hashkart.product.entities.ProductCategories;
import com.hashkart.product.entities.ProductDetails;
import com.hashkart.product.repositories.ProductCategoriesRepository;
import com.hashkart.product.repositories.ProductDetailsRepository;
import com.hashkart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductCategoriesRepository productCategoriesRepository;

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    @Override
    public List<ProductCategories> showProducts() {
        return productCategoriesRepository.findAll();
    }

    @Override
    public List<ProductDetails> showProductsByCategory(String categoryName) {

        // Get Category ID using Category Name
        ProductCategories productCategories = productCategoriesRepository.findByCategoryName(categoryName);

        // Return Products using Category ID
        return productCategories == null ? null : productDetailsRepository.findByCategoryId(productCategories.getCategoryId());
    }
}
