package com.example1.billingsoftware1.controller;


import com.example1.billingsoftware1.io.OrderResponse;
import com.example1.billingsoftware1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example1.billingsoftware1.io.DashboardResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final OrderService orderService;

    @GetMapping
    public DashboardResponse getDashboardData(){
        LocalDate today=LocalDate.now();
        Double totalSale=orderService.sumSalesByDate(today);
        Long todayOrderCount=orderService.countOrdersByDate(today);
       List<OrderResponse> recentOrders=orderService.findRecentOrders();
       return new DashboardResponse(
        totalSale !=null ? totalSale : 0.0,
        todayOrderCount!=null ? todayOrderCount : 0L,
        recentOrders
        );
    }

}
