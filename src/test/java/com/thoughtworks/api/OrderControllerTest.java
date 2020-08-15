package com.thoughtworks.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.dto.ItemDto;
import com.thoughtworks.dto.OrderDto;
import com.thoughtworks.repository.OrderRepository;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    OrderRepository orderRepository;

    @Test
    @Order(1)
    void when_perform_get_order_then_return_all_order() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    void when_perform_delete_order_then_delete_all() throws Exception {
        mockMvc.perform(post("/orderDelete"))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/orders"))
                .andExpect(jsonPath("$", hasSize(0)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void when_perform_add_order_then_save() throws Exception{
        OrderDto orderDto = OrderDto.builder().order_name("o1").order_time("19").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String orderDtoStr = objectMapper.writeValueAsString(orderDto);
        mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON)
                .content(orderDtoStr)).andExpect(status().isCreated());
    }
}
