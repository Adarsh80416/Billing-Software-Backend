package com.example1.billingsoftware1.service;

import com.example1.billingsoftware1.io.RazorpayOrderResponse;
import com.razorpay.RazorpayException;

public interface RazorpayService {

  RazorpayOrderResponse createOrder(Double amount, String currency)throws RazorpayException;
}
