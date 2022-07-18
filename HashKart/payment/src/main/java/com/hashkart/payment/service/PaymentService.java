package com.hashkart.payment.service;

import com.hashkart.payment.entities.Payment;

public interface PaymentService {
    public Payment doPayment(Payment payment);

    public Payment findPaymentDetailsByUserId(int userId);
}
