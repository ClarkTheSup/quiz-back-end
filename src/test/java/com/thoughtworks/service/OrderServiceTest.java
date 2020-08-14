package com.thoughtworks.service;

import com.thoughtworks.domain.Item;
import com.thoughtworks.domain.Order;
import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.dto.OrderDto;
import com.thoughtworks.repository.ItemRepository;
import com.thoughtworks.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class OrderServiceTest {
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @BeforeEach
    public void setUp(){
        initMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void when_find_all_then_return_order() {
        //given
        OrderDto orderDto = OrderDto.builder().name("o1").time("19").build();
        List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
        orderDtoList.add(orderDto);
        List<Order> orderList = new ArrayList<Order>();
        Order order = Order.builder().name(orderDto.getName())
                .time(orderDto.getTime()).build();
        orderList.add(order);

        //when
        when(orderRepository.findAll()).thenReturn(orderDtoList);

        //then
        assertEquals(orderRepository.findAll().size(), 1);
        assertEquals(orderService.getOrderList(), orderList);
        verify(orderRepository, times(2)).findAll();
    }

    @Test
    void should_delete_order() {
        orderService.deleteOrder();
        verify(orderRepository, times(1)).deleteAll();
    }
}