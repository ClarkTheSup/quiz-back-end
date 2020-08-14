package com.thoughtworks.api;

import com.thoughtworks.domain.Order;
import com.thoughtworks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping("/order")
    public ResponseEntity getOrder() {
        List<Order> orderList = orderService.getOrderList();
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }
}
