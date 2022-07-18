package com.hashkart.cart.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int paymentId;
    private int userId;
    private String paymentStatus;
    private String transactionId;
    private double amount;

}
