package com.thoughtworks.service;

import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class MarketServiceTest {
    MarketService marketService;

    @Mock
    ItemRepository itemRepository;

    @BeforeEach
    public void setUp(){
       initMocks(this);
       marketService = new MarketService(itemRepository);
    }

    @Test
    void when_find_all_then_return_all_items() {
        //given
        ItemDto itemDto = ItemDto.builder().id(1)
                            .name("kele").measurement("瓶")
                            .price(2).image_url("../../images/1.jpg")
                            .build();
        List<ItemDto> itemDtoList = new ArrayList<ItemDto>();
        itemDtoList.add(itemDto);

        //when
        when(itemRepository.findAll()).thenReturn(itemDtoList);

        //then
        assertEquals(marketService.findAll().size(), 1);
        verify(itemRepository).findAll();
    }
}