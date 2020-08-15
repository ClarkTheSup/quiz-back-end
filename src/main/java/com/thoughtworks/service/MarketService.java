package com.thoughtworks.service;

import com.thoughtworks.domain.Item;
import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
    private ItemRepository itemRepository;

    public MarketService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        List<ItemDto> itemDtoList = itemRepository.findAll();
        List<Item> itemList = new ArrayList<Item>();
        itemDtoList.stream().forEach(itemDto -> {
            Item item = Item.builder().name(itemDto.getName())
                            .price(itemDto.getPrice())
                            .measurement(itemDto.getMeasurement())
                            .image(itemDto.getImage())
                            .build();
            itemList.add(item);
        });
        return itemList;
    }

    public void saveItem(Item item) {
        ItemDto itemDto = ItemDto.builder().name(item.getName())
                            .price(item.getPrice()).measurement(item.getMeasurement())
                            .image(item.getImage()).build();
        itemRepository.save(itemDto);
    }
}
