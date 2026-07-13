package com.example1.billingsoftware1.service;

import com.example1.billingsoftware1.io.OrderRequest;
import com.example1.billingsoftware1.io.OrderResponse;
import com.example1.billingsoftware1.io.PaymentVerificationRequest;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.Page;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    void deleteOrder(String orderId);

    List<OrderResponse> getLatestOrders();

    OrderResponse verifyPayment(PaymentVerificationRequest request);

    Double sumSalesByDate(LocalDate date);

    Long countOrdersByDate(LocalDate date);

    List<OrderResponse> findRecentOrders();



}
