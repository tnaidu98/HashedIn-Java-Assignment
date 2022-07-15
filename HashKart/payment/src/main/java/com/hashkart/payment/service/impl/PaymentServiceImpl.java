package com.hashkart.payment.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashkart.payment.entities.Payment;
import com.hashkart.payment.repositories.PaymentRepository;
import com.hashkart.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment doPayment(Payment payment) {

        payment.setPayment_status(paymentProcessing());
        payment.setTransaction_id(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessing(){
        //API should be 3rd party Payment Gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }

    @Override
    public Payment findPaymentDetailsByUserId(int user_id) {
        Payment payment=paymentRepository.findByUser_Id(user_id);
        return payment ;
    }

}
