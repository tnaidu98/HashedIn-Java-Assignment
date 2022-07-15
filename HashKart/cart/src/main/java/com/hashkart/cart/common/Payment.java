package com.hashkart.cart.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private int paymentId;
    private int user_id;
    private String payment_status;
    private String transaction_id;
    private double amount;
}
