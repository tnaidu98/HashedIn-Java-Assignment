package com.hashkart.cart.common;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private ProductsInCart productsInCart;
    private String transactionId;
    private String message;
}
