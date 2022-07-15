package com.hashkart.cart.service.impl;

import com.hashkart.cart.common.*;
import com.hashkart.cart.entities.Cart_Details;
import com.hashkart.cart.repositories.CartRepository;
import com.hashkart.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String addProductToCart(Cart_Details product_details) {
        try {
            cartRepository.save(product_details);
        }
        catch (Exception e){
            return String.valueOf(e);
        }

        return "Product added to Cart";
    }

    @Override
    public ProductsInCart getProductsInCart(int user_id) {
        ProductsInCart productsInCart = new ProductsInCart();
        List<Cart_Details> cart_detailsList = cartRepository.findAllByUserId(user_id);
        if(cart_detailsList.isEmpty())
            return null;
        else {
            productsInCart.setCart_detailsList(cart_detailsList);
            productsInCart.setTotalPrice(cartRepository.findTotalPrice(user_id));
            return productsInCart;
        }
    }

    @Override
    public TransactionResponse cartCheckoutAndPayment(TransactionRequest request) {

        String response = "";
        ProductsInCart productsInCart = request.getProductsInCart();
        Payment payment = request.getPayment();
        payment.setUser_id(productsInCart.getCart_detailsList().get(0).getUser_id());
        payment.setAmount(productsInCart.getTotalPrice());

        //REST call
        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);

        if(paymentResponse.getPayment_status().equals("success")){
            response = "Payment processing successful and Order placed";
            cartRepository.deleteByUser_Id(productsInCart.getCart_detailsList().get(0).getUser_id());
        }
        else {
            response = "there is a failure in Payment API, order added to cart";
        }

        return new TransactionResponse(productsInCart,paymentResponse.getTransaction_id(), response);
    }


}
