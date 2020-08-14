package com.thoughtworks.repository;

import com.thoughtworks.domain.Order;
import com.thoughtworks.dto.OrderDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderDto, Integer> {
    @Override
    List<OrderDto> findAll();
}
