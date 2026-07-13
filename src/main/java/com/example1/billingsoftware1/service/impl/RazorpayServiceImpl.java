package com.example1.billingsoftware1.service.impl;

import com.example1.billingsoftware1.io.RazorpayOrderResponse;
import com.example1.billingsoftware1.service.RazorpayService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.NoArgsConstructor;
import java.sql.Date;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
public class RazorpayServiceImpl implements RazorpayService {

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Override
    public RazorpayOrderResponse createOrder(Double amount, String currency) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);
        JSONObject orderRequest=new JSONObject();
        orderRequest.put("amount",amount*100);
        orderRequest.put("currency",currency);
        orderRequest.put("receipt","order_rcptid"+System.currentTimeMillis());
        orderRequest.put("payment_capture",1);

        Order order = razorpayClient.orders.create(orderRequest);
        return convertToResponse(order);

    }

    private RazorpayOrderResponse convertToResponse(Order order){
     return RazorpayOrderResponse.builder()
                .id(order.get("id"))
                .entity(order.get("entity"))
                .amount(order.get("amount"))
                .currency(order.get("currency"))
                .status(order.get("status"))
             .createdAt(new Date(((java.util.Date) order.get("created_at")).getTime()))
                .receipt(order.get("receipt"))
                .build();

    }

}