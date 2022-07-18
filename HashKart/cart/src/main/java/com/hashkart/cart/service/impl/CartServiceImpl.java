package com.hashkart.cart.service.impl;

import com.hashkart.cart.common.*;
import com.hashkart.cart.entities.CartDetails;
import com.hashkart.cart.repositories.CartRepository;
import com.hashkart.cart.repositories.PaymentFeignClient;
import com.hashkart.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    PaymentFeignClient paymentFeignClient;

    @Override
    public String addProductToCart(CartDetails product_details) {
        try {
            cartRepository.save(product_details);
        }
        catch (Exception e){
            return String.valueOf(e);
        }

        return "Product added to Cart";
    }

    @Override
    public ProductsInCart getProductsInCart(int userId) {
        ProductsInCart productsInCart = new ProductsInCart();
        List<CartDetails> cart_detailsList = cartRepository.findAllByUserId(userId);
        if(cart_detailsList.isEmpty())
            return null;
        else {
            productsInCart.setCartDetailsList(cart_detailsList);
            productsInCart.setTotalPrice(cartRepository.findTotalPrice(userId));
            return productsInCart;
        }
    }

    @Override
    public TransactionResponse cartCheckoutAndPayment(TransactionRequest request) {

        String response = "";
        ProductsInCart productsInCart = request.getProductsInCart();
        Payment payment = request.getPayment();
        payment.setUserId(productsInCart.getCartDetailsList().get(0).getUserId());
        payment.setAmount(productsInCart.getTotalPrice());

        //REST call
        Payment paymentResponse = paymentFeignClient.doPayment(payment);

        if(paymentResponse.getPaymentStatus().equals("success")){
            response = "Payment processing successful and Order placed";
            cartRepository.deleteByUserId(productsInCart.getCartDetailsList().get(0).getUserId());
        }
        else {
            response = "there is a failure in Payment API, order added to cart";
        }

        return new TransactionResponse(productsInCart,paymentResponse.getTransactionId(), response);
    }


}
