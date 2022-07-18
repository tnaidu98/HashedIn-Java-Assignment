package com.hashkart.product.controllers;

import com.hashkart.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> showProducts(@RequestParam(defaultValue = "empty") String categoryName,
                                          HttpServletResponse response, HttpServletRequest request) {

        if (categoryName.equals("empty")) {
            return new ResponseEntity<>(productService.showProducts(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(productService.showProductsByCategory(categoryName),HttpStatus.OK);
        }
    }

}
