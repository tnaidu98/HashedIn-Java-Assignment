package com.hashkart.cart.repositories;

import com.hashkart.cart.common.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentFeignClient {

    @RequestMapping(value = "/payment/doPayment", method = RequestMethod.POST)
    Payment doPayment(@RequestBody Payment payment);

}
