package com.thoughtworks.service;

import com.thoughtworks.domain.Item;
import com.thoughtworks.repository.OrderRepository;
import com.thoughtworks.domain.Order;
import com.thoughtworks.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderList() {
        List<OrderDto> orderDtoList = orderRepository.findAll();
        List<Order> OrderList = new ArrayList<Order>();
        orderDtoList.stream().forEach(orderDto -> {
            Order order = Order.builder().name(orderDto.getName())
                            .time(orderDto.getTime())
                            .item_id(orderDto.getItem_id()).build();
            OrderList.add(order);
        });
        return OrderList;
    }

    @Transactional
    public void deleteOrder() {
        orderRepository.deleteAll();
    }

    @Transactional
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }
}
