package com.hashkart.product.service.impl;

import com.hashkart.product.entities.Product_Categories;
import com.hashkart.product.entities.Product_Details;
import com.hashkart.product.repositories.Product_CategoriesRepository;
import com.hashkart.product.repositories.Product_DetailsRepository;
import com.hashkart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    Product_CategoriesRepository product_categoriesRepository;

    @Autowired
    Product_DetailsRepository product_detailsRepository;

    @Override
    public List<Product_Categories> showProducts() {
        return product_categoriesRepository.findAll();
    }

    @Override
    public List<Product_Details> showProductsByCategory(String category_name) {

        Product_Categories product_categories = product_categoriesRepository.findByCategoryName(category_name);
        return product_categories == null ? null : product_detailsRepository.findByCategoryId(product_categories.getCategory_id());
    }
}
