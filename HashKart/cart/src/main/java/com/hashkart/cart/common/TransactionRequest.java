package com.hashkart.cart.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TransactionRequest {

    private ProductsInCart productsInCart;
    private Payment payment;
}
