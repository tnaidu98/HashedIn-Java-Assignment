package com.hashkart.cart.service;

import com.hashkart.cart.common.ProductsInCart;
import com.hashkart.cart.common.TransactionRequest;
import com.hashkart.cart.common.TransactionResponse;
import com.hashkart.cart.entities.Cart_Details;

public interface CartService {
    public String addProductToCart(Cart_Details product_details);

    public ProductsInCart getProductsInCart(int user_id);

    public TransactionResponse cartCheckoutAndPayment(TransactionRequest request);
}
