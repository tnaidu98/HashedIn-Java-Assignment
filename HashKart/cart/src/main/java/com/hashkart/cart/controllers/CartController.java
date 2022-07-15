package com.hashkart.cart.controllers;

import com.hashkart.cart.common.TransactionRequest;
import com.hashkart.cart.common.TransactionResponse;
import com.hashkart.cart.entities.Cart_Details;
import com.hashkart.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/addProductToCart")
    public ResponseEntity<?> addProductToCart(@RequestBody Cart_Details product_details) {
        return new ResponseEntity<>(cartService.addProductToCart(product_details),HttpStatus.OK);
    }

    @GetMapping("/getProductsInCart")
    public ResponseEntity<?> getProductsInCart(@RequestParam int user_id){
        return new ResponseEntity<>(cartService.getProductsInCart(user_id),HttpStatus.OK);
    }

    @PostMapping("/cartCheckoutAndPayment")
    public TransactionResponse cartCheckoutAndPayment(@RequestBody TransactionRequest request) {
        return cartService.cartCheckoutAndPayment(request);
    }
}
