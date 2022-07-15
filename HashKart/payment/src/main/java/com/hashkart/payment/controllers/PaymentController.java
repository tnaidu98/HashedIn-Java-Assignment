package com.hashkart.payment.controllers;

import com.hashkart.payment.entities.Payment;
import com.hashkart.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
        @Autowired
        private PaymentService paymentService;

        @PostMapping("/doPayment")
        public Payment doPayment(@RequestBody Payment payment) {
            return paymentService.doPayment(payment);
        }

        @GetMapping("/{orderId}")
        public Payment findPaymentDetailsByUserId(@PathVariable int user_id){
            return paymentService.findPaymentDetailsByUserId(user_id);
        }
}
