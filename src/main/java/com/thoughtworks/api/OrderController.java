package com.thoughtworks.api;

import com.thoughtworks.domain.Item;
import com.thoughtworks.domain.Order;
import com.thoughtworks.dto.OrderDto;
import com.thoughtworks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity getOrder() {
        List<Item> itemList = orderService.getItemList();
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }

    @PostMapping("/orderDelete")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity deleteOrder() {
        orderService.deleteOrder();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/orderDelete/{id}")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity deleteOrderById(@PathVariable int id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/order")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity addOrder(@RequestBody OrderDto orderDto) {
        orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
