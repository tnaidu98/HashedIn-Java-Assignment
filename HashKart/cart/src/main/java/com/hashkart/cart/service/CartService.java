package com.hashkart.cart.service;

import com.hashkart.cart.common.ProductsInCart;
import com.hashkart.cart.common.TransactionRequest;
import com.hashkart.cart.common.TransactionResponse;
import com.hashkart.cart.entities.CartDetails;

public interface CartService {
    public String addProductToCart(CartDetails product_details);

    public ProductsInCart getProductsInCart(int user_id);

    public TransactionResponse cartCheckoutAndPayment(TransactionRequest request);
}
