package com.example1.billingsoftware1.controller;


import com.example1.billingsoftware1.io.OrderResponse;
import com.example1.billingsoftware1.io.PaymentRequest;
import com.example1.billingsoftware1.io.PaymentVerificationRequest;
import com.example1.billingsoftware1.service.OrderService;
import com.example1.billingsoftware1.service.RazorpayService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example1.billingsoftware1.io.RazorpayOrderResponse;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final RazorpayService razorpayService;
    private final OrderService orderService;


    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public RazorpayOrderResponse createRazorpayOrder(@RequestBody PaymentRequest request) throws RazorpayException{

        return razorpayService.createOrder(request.getAmount(),request.getCurrency());

    }
    @PostMapping("/verify")
    public OrderResponse verifyPayment(@RequestBody PaymentVerificationRequest request){
        return orderService.verifyPayment(request);
    }
    

}
