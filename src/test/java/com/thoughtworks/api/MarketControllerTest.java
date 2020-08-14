package com.thoughtworks.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.domain.Item;
import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MarketControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        itemRepository.deleteAll();
    }

    @Test
    @Order(1)
    void when_get_market_then_return_all_items() throws Exception {
        ItemDto itemDto1 = ItemDto.builder().id(1).name("kele1").measurement("瓶")
                .price(2).image_url("../../images/1.jpg").build();
        ItemDto itemDto2 = ItemDto.builder().id(2).name("kele2").measurement("瓶")
                .price(4).image_url("../../images/1.jpg").build();

        itemRepository.save(itemDto1);
        itemRepository.save(itemDto2);
        mockMvc.perform(get("/market"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("kele1")))
                .andExpect(jsonPath("$[1].name", is("kele2")))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void given_item_then_save() throws Exception {
        ItemDto itemDto = ItemDto.builder().name("kele").measurement("瓶")
                .price(2).image_url("../../images/1.jpg").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String itemDtoStr = objectMapper.writeValueAsString(itemDto);
        mockMvc.perform(post("/market/item").contentType(MediaType.APPLICATION_JSON)
        .content(itemDtoStr)).andExpect(status().isCreated());

        mockMvc.perform(get("/market")).andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("kele")))
                .andExpect(jsonPath("$[0].price", is(2.0)))
                .andExpect(jsonPath("$[0].measurement", is("瓶")))
                .andExpect(jsonPath("$[0].image_url", is("../../images/1.jpg")));
    }
}