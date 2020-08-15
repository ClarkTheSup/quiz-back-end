package com.thoughtworks.repository;

import com.thoughtworks.dto.ItemDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends CrudRepository<ItemDto, Integer> {
    @Override
    List<ItemDto> findAll();

    @Override
    Optional<ItemDto> findById(Integer integer);
}
